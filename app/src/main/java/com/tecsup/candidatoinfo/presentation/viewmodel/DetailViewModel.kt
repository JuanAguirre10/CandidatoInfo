package com.tecsup.candidatoinfo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tecsup.candidatoinfo.core.util.UiState
import com.tecsup.candidatoinfo.data.model.Candidato
import com.tecsup.candidatoinfo.data.model.Denuncia
import com.tecsup.candidatoinfo.data.model.Propuesta
import com.tecsup.candidatoinfo.data.repository.CandidatoRepository
import com.tecsup.candidatoinfo.data.repository.CandidatoRepositoryImpl
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    private val repository: CandidatoRepository = CandidatoRepositoryImpl()

    private val _candidatoState = MutableStateFlow<UiState<Candidato>>(UiState.Idle)
    val candidatoState: StateFlow<UiState<Candidato>> = _candidatoState.asStateFlow()

    private val _denunciasState = MutableStateFlow<UiState<List<Denuncia>>>(UiState.Idle)
    val denunciasState: StateFlow<UiState<List<Denuncia>>> = _denunciasState.asStateFlow()

    private val _propuestasState = MutableStateFlow<UiState<List<Propuesta>>>(UiState.Idle)
    val propuestasState: StateFlow<UiState<List<Propuesta>>> = _propuestasState.asStateFlow()

    private val _selectedTab = MutableStateFlow(0)
    val selectedTab: StateFlow<Int> = _selectedTab.asStateFlow()

    fun loadCandidatoData(candidatoId: String) {
        loadCandidato(candidatoId)
        loadDenuncias(candidatoId)
        loadPropuestas(candidatoId)
    }

    private fun loadCandidato(candidatoId: String) {
        viewModelScope.launch {
            _candidatoState.value = UiState.Loading

            try {
                delay(300)

                val candidato = repository.getCandidatoById(candidatoId)

                if (candidato != null) {
                    _candidatoState.value = UiState.Success(candidato)
                } else {
                    _candidatoState.value = UiState.Error("Candidato no encontrado")
                }
            } catch (e: Exception) {
                _candidatoState.value = UiState.Error(e.message ?: "Error al cargar candidato")
            }
        }
    }


    private fun loadDenuncias(candidatoId: String) {
        viewModelScope.launch {
            _denunciasState.value = UiState.Loading

            try {
                delay(400)

                val denuncias = repository.getDenunciasByCandidato(candidatoId)

                if (denuncias.isEmpty()) {
                    _denunciasState.value = UiState.Empty
                } else {
                    _denunciasState.value = UiState.Success(denuncias)
                }
            } catch (e: Exception) {
                _denunciasState.value = UiState.Error(e.message ?: "Error al cargar denuncias")
            }
        }
    }


    private fun loadPropuestas(candidatoId: String) {
        viewModelScope.launch {
            _propuestasState.value = UiState.Loading

            try {
                delay(350)

                val propuestas = repository.getPropuestasByCandidato(candidatoId)

                if (propuestas.isEmpty()) {
                    _propuestasState.value = UiState.Empty
                } else {
                    _propuestasState.value = UiState.Success(propuestas)
                }
            } catch (e: Exception) {
                _propuestasState.value = UiState.Error(e.message ?: "Error al cargar propuestas")
            }
        }
    }


    fun updateSelectedTab(tab: Int) {
        _selectedTab.value = tab
    }


    fun reloadData(candidatoId: String) {
        loadCandidatoData(candidatoId)
    }
}