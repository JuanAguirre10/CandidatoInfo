package com.tecsup.candidatoinfo.data.model

data class Candidato(
    val id: String,
    val nombreCompleto: String,
    val partidoPolitico: String,
    val cargo: String, // "Presidente" o "Congresista"
    val fotoResId: Int, // 👈 referencia a imagen local en drawable
    val edad: Int,
    val lugarNacimiento: String,
    val profesion: String,
    val numeroDenuncias: Int = 0,
    val numeroProyectos: Int = 0
)
