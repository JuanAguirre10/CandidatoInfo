package com.tecsup.candidatoinfo.data.datasource

import com.tecsup.candidatoinfo.R
import com.tecsup.candidatoinfo.data.model.Candidato

object MockDataSource {
    val candidatos = listOf(
        Candidato(
            id = "1",
            nombreCompleto = "Dina Boluarte Zegarra",
            partidoPolitico = "Independiente",
            cargo = "Presidenta de la República",
            fotoResId = R.drawable.dina,
            edad = 62,
            lugarNacimiento = "Apurímac",
            profesion = "Abogada",
            numeroDenuncias = 1,
            numeroProyectos = 12
        ),
        Candidato(
            id = "2",
            nombreCompleto = "Keiko Sofía Fujimori Higuchi",
            partidoPolitico = "Fuerza Popular",
            cargo = "Excandidata presidencial",
            fotoResId = R.drawable.keiko,
            edad = 49,
            lugarNacimiento = "Lima",
            profesion = "Administradora de Empresas",
            numeroDenuncias = 2,
            numeroProyectos = 18
        ),
        Candidato(
            id = "3",
            nombreCompleto = "Verónika Fanny Mendoza Frisch",
            partidoPolitico = "Juntos por el Perú",
            cargo = "Excandidata presidencial",
            fotoResId = R.drawable.veronica,
            edad = 44,
            lugarNacimiento = "Cusco",
            profesion = "Antropóloga",
            numeroDenuncias = 0,
            numeroProyectos = 10
        )
    )
}
