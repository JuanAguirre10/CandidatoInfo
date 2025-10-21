package com.tecsup.candidatoinfo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tecsup.candidatoinfo.core.util.UiState
import com.tecsup.candidatoinfo.data.model.Candidato
import com.tecsup.candidatoinfo.data.repository.CandidatoRepository
import com.tecsup.candidatoinfo.data.repository.CandidatoRepositoryImpl
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository: CandidatoRepository = CandidatoRepositoryImpl()

    private val _uiState = MutableStateFlow<UiState<List<Candidato>>>(UiState.Idle)
    val uiState: StateFlow<UiState<List<Candidato>>> = _uiState.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedFilter = MutableStateFlow("Todos")
    val selectedFilter: StateFlow<String> = _selectedFilter.asStateFlow()

    init {
        loadCandidatos()
    }

    fun loadCandidatos() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading

            try {
                // Simular delay de red
                delay(500)

                val candidatos = repository.getCandidatos()

                if (candidatos.isEmpty()) {
                    _uiState.value = UiState.Empty
                } else {
                    _uiState.value = UiState.Success(candidatos)
                }
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Error desconocido")
            }
        }
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
        searchCandidatos(query)
    }

    fun updateFilter(filter: String) {
        _selectedFilter.value = filter
        applyFilters()
    }

    private fun searchCandidatos(query: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading

            try {
                delay(300) // Debounce

                val results = if (query.isBlank()) {
                    repository.getCandidatos()
                } else {
                    repository.searchCandidatos(query)
                }

                // Aplicar filtro de cargo también
                val filtered = if (_selectedFilter.value != "Todos") {
                    results.filter {
                        it.cargo.contains(_selectedFilter.value, ignoreCase = true)
                    }
                } else {
                    results
                }

                if (filtered.isEmpty()) {
                    _uiState.value = UiState.Empty
                } else {
                    _uiState.value = UiState.Success(filtered)
                }
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Error en la búsqueda")
            }
        }
    }


    private fun applyFilters() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading

            try {
                delay(200)

                val filtered = when (_selectedFilter.value) {
                    "Congreso" -> repository.filterByCargo("Congresista")
                    "Presidencia" -> repository.filterByCargo("Presidente")
                    else -> repository.getCandidatos()
                }

                val results = if (_searchQuery.value.isNotBlank()) {
                    filtered.filter { candidato ->
                        candidato.nombreCompleto.contains(_searchQuery.value, ignoreCase = true) ||
                                candidato.partidoPolitico.contains(_searchQuery.value, ignoreCase = true)
                    }
                } else {
                    filtered
                }

                if (results.isEmpty()) {
                    _uiState.value = UiState.Empty
                } else {
                    _uiState.value = UiState.Success(results)
                }
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Error al filtrar")
            }
        }
    }


    fun resetFilters() {
        _searchQuery.value = ""
        _selectedFilter.value = "Todos"
        loadCandidatos()
    }
}