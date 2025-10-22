package com.tecsup.candidatoinfo.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import com.tecsup.candidatoinfo.data.model.Candidato

class CompareViewModel : ViewModel() {

    private val _selectedCandidatos = mutableStateOf<List<Candidato>>(emptyList())
    val selectedCandidatos: State<List<Candidato>> = _selectedCandidatos

    fun toggleCandidato(candidato: Candidato) {
        val current = _selectedCandidatos.value.toMutableList()

        if (current.any { it.id == candidato.id }) {
            current.removeAll { it.id == candidato.id }
        } else {
            if (current.size < 3) {
                current.add(candidato)
            }
        }

        _selectedCandidatos.value = current
    }

    fun isSelected(candidatoId: String): Boolean {
        return _selectedCandidatos.value.any { it.id == candidatoId }
    }

    fun clearSelection() {
        _selectedCandidatos.value = emptyList()
    }

    fun canCompare(): Boolean {
        return _selectedCandidatos.value.size >= 2
    }
}