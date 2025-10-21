package com.tecsup.candidatoinfo.data.datasource

import com.tecsup.candidatoinfo.data.model.Candidato

object MockDataSource {
    val candidatos = listOf(
        Candidato(
            id = "1",
            nombreCompleto = "Silvia Montoya Vargas",
            partidoPolitico = "partido morado",
            cargo = "presidente - Nacional",
            fotoUrl = "https://via.placeholder.com/150",
            edad = 52,
            lugarNacimiento = "Lima",
            profesion = "derecho - universidad USMP",
            numeroDenuncias = 1,
            numeroProyectos = 12
        ),
        Candidato(
            id = "2",
            nombreCompleto = "Carlos Aguirre Araujo",
            partidoPolitico = "alianza nacional",
            cargo = "Congresista - Lima",
            fotoUrl = "https://via.placeholder.com/150",
            edad = 45,
            lugarNacimiento = "Lima",
            profesion = "Ingeniero Civil",
            numeroDenuncias = 0,
            numeroProyectos = 8
        ),
        Candidato(
            id = "3",
            nombreCompleto = "Nelly Solorzano Chacón",
            partidoPolitico = "Movimiento Naranja",
            cargo = "Congresista - Cusco",
            fotoUrl = "https://via.placeholder.com/150",
            edad = 38,
            lugarNacimiento = "Cusco",
            profesion = "Economista",
            numeroDenuncias = 2,
            numeroProyectos = 15
        ),
        Candidato(
            id = "4",
            nombreCompleto = "Roberto Paz Miranda",
            partidoPolitico = "Partido Democrático",
            cargo = "Presidente - Nacional",
            fotoUrl = "https://via.placeholder.com/150",
            edad = 48,
            lugarNacimiento = "Arequipa",
            profesion = "Abogado",
            numeroDenuncias = 3,
            numeroProyectos = 20
        ),
        Candidato(
            id = "5",
            nombreCompleto = "Ana María Torres Vega",
            partidoPolitico = "Alianza Popular",
            cargo = "Congresista - Lima",
            fotoUrl = "https://via.placeholder.com/150",
            edad = 42,
            lugarNacimiento = "Lima",
            profesion = "Contadora",
            numeroDenuncias = 0,
            numeroProyectos = 18
        )
    )
}