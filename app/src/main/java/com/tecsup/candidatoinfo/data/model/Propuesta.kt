package com.tecsup.candidatoinfo.data.model

data class Propuesta(
    val id: String,
    val candidatoId: String,
    val titulo: String,
    val descripcion: String,
    val categoria: String,
    val fechaPresentacion: String,
    val estado: String,
    val linkFuenteOficial: String
)