package com.tecsup.candidatoinfo.data.datasource

import com.tecsup.candidatoinfo.data.model.Candidato

object MockDataSource {
    val candidatos = listOf(
        Candidato(
            id = "1",
            nombreCompleto = "Juan Pérez García",
            partidoPolitico = "Partido Democrático",
            cargo = "Presidente",
            fotoUrl = "https://via.placeholder.com/150",
            edad = 45,
            lugarNacimiento = "Lima",
            profesion = "Abogado",
            numeroDenuncias = 2,
            numeroProyectos = 15
        ),
        Candidato(
            id = "2",
            nombreCompleto = "María López Silva",
            partidoPolitico = "Partido Popular",
            cargo = "Congresista",
            fotoUrl = "https://via.placeholder.com/150",
            edad = 38,
            lugarNacimiento = "Arequipa",
            profesion = "Economista",
            numeroDenuncias = 0,
            numeroProyectos = 8
        ),
        Candidato(
            id = "3",
            nombreCompleto = "Carlos Rodríguez Vega",
            partidoPolitico = "Alianza Nacional",
            cargo = "Presidente",
            fotoUrl = "https://via.placeholder.com/150",
            edad = 52,
            lugarNacimiento = "Cusco",
            profesion = "Ingeniero",
            numeroDenuncias = 1,
            numeroProyectos = 22
        )
    )
}
