package com.tecsup.candidatoinfo.data.repository

import com.tecsup.candidatoinfo.data.model.Candidato
import com.tecsup.candidatoinfo.data.model.Denuncia
import com.tecsup.candidatoinfo.data.model.Propuesta

interface CandidatoRepository {

    fun getCandidatos(): List<Candidato>

    fun getCandidatoById(id: String): Candidato?

    fun getDenunciasByCandidato(candidatoId: String): List<Denuncia>

    fun getPropuestasByCandidato(candidatoId: String): List<Propuesta>

    fun getDenunciaById(denunciaId: String): Denuncia?

    fun getPropuestaById(propuestaId: String): Propuesta?

    fun searchCandidatos(query: String): List<Candidato>

    fun filterByCargo(cargo: String): List<Candidato>

    fun filterByRegion(region: String): List<Candidato>

    fun getRegiones(): List<String>
}
