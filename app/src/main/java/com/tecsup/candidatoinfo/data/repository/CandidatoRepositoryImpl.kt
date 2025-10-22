package com.tecsup.candidatoinfo.data.repository

import com.tecsup.candidatoinfo.data.datasource.MockDataSource
import com.tecsup.candidatoinfo.data.model.Candidato

class CandidatoRepositoryImpl : CandidatoRepository {

    private val dataSource = MockDataSource

    override fun getCandidatos() = dataSource.candidatos

    override fun getCandidatoById(id: String) =
        dataSource.candidatos.find { it.id == id }

    override fun getDenunciasByCandidato(candidatoId: String) =
        dataSource.getDenunciasByCandidato(candidatoId)

    override fun getPropuestasByCandidato(candidatoId: String) =
        dataSource.getPropuestasByCandidato(candidatoId)

    override fun getDenunciaById(denunciaId: String) =
        dataSource.getDenunciaById(denunciaId)

    override fun getPropuestaById(propuestaId: String) =
        dataSource.getPropuestaById(propuestaId)

    override fun searchCandidatos(query: String): List<Candidato> {
        if (query.isBlank()) return dataSource.candidatos

        return dataSource.candidatos.filter { candidato ->
            candidato.nombreCompleto.contains(query, ignoreCase = true) ||
                    candidato.partidoPolitico.contains(query, ignoreCase = true) ||
                    candidato.cargo.contains(query, ignoreCase = true)
        }
    }

    override fun filterByCargo(cargo: String): List<Candidato> {
        if (cargo == "Todos") return dataSource.candidatos

        return dataSource.candidatos.filter {
            it.cargo.contains(cargo, ignoreCase = true)
        }
    }

    override fun filterByRegion(region: String): List<Candidato> {
        if (region == "Todas") return dataSource.candidatos

        return dataSource.candidatos.filter {
            it.lugarNacimiento.contains(region, ignoreCase = true) ||
                    it.cargo.contains(region, ignoreCase = true)
        }
    }

    override fun getRegiones(): List<String> {
        return listOf(
            "Todas",
            "Lima",
            "Cusco",
            "Arequipa",
            "Trujillo"
        )
    }
}