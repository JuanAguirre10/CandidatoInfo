package com.tecsup.candidatoinfo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tecsup.candidatoinfo.data.datasource.MockDataSource
import com.tecsup.candidatoinfo.data.model.Candidato
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    private val _candidato = MutableStateFlow<Candidato?>(null)
    val candidato: StateFlow<Candidato?> = _candidato.asStateFlow()

    private val _selectedTab = MutableStateFlow(0)
    val selectedTab: StateFlow<Int> = _selectedTab.asStateFlow()

    fun loadCandidato(candidatoId: String) {
        viewModelScope.launch {
            _candidato.value = MockDataSource.candidatos.find { it.id == candidatoId }
        }
    }

    fun updateSelectedTab(tab: Int) {
        _selectedTab.value = tab
    }
}