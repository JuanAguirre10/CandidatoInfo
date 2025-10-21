package com.tecsup.candidatoinfo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tecsup.candidatoinfo.data.datasource.MockDataSource
import com.tecsup.candidatoinfo.data.model.Candidato
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _candidatos = MutableStateFlow<List<Candidato>>(emptyList())
    val candidatos: StateFlow<List<Candidato>> = _candidatos.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedFilter = MutableStateFlow("Todos")
    val selectedFilter: StateFlow<String> = _selectedFilter.asStateFlow()

    init {
        loadCandidatos()
    }

    private fun loadCandidatos() {
        viewModelScope.launch {
            _candidatos.value = MockDataSource.candidatos
        }
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun updateFilter(filter: String) {
        _selectedFilter.value = filter
    }

    fun getFilteredCandidatos(): List<Candidato> {
        var filtered = when (_selectedFilter.value) {
            "Congreso" -> _candidatos.value.filter {
                it.cargo.contains("Congresista", ignoreCase = true)
            }
            "Presidencia" -> _candidatos.value.filter {
                it.cargo.contains("Presidente", ignoreCase = true)
            }
            else -> _candidatos.value
        }

        if (_searchQuery.value.isNotBlank()) {
            filtered = filtered.filter {
                it.nombreCompleto.contains(_searchQuery.value, ignoreCase = true) ||
                        it.partidoPolitico.contains(_searchQuery.value, ignoreCase = true)
            }
        }

        return filtered
    }
}