package com.tecsup.candidatoinfo.data.datasource

import com.tecsup.candidatoinfo.R
import com.tecsup.candidatoinfo.data.model.Candidato

object MockDataSource {

    val candidatos = listOf(
        Candidato(
            id = "1",
            nombreCompleto = "Dina Boluarte Zegarra",
            partidoPolitico = "Independiente",
            cargo = "Presidenta del Perú",
            fotoResId = R.drawable.dina, // 👈 imagen en drawable
            edad = 61,
            lugarNacimiento = "Apurímac, Perú",
            profesion = "Abogada",
            numeroDenuncias = 2,
            numeroProyectos = 15
        ),
        Candidato(
            id = "2",
            nombreCompleto = "Keiko Fujimori Higuchi",
            partidoPolitico = "Fuerza Popular",
            cargo = "Líder del partido Fuerza Popular",
            fotoResId = R.drawable.keiko, // 👈 imagen en drawable
            edad = 49,
            lugarNacimiento = "Lima, Perú",
            profesion = "Economista",
            numeroDenuncias = 5,
            numeroProyectos = 8
        ),
        Candidato(
            id = "3",
            nombreCompleto = "Verónica Mendoza Frisch",
            partidoPolitico = "Nuevo Perú",
            cargo = "Líder del movimiento progresista Nuevo Perú",
            fotoResId = R.drawable.veronica, // 👈 imagen en drawable
            edad = 44,
            lugarNacimiento = "Cusco, Perú",
            profesion = "Psicóloga",
            numeroDenuncias = 0,
            numeroProyectos = 22
        )
    )
}
