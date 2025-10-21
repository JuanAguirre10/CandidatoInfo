package com.tecsup.candidatoinfo.data.model

data class Denuncia(
    val id: String,
    val candidatoId: String,
    val titulo: String,
    val descripcion: String,
    val tipo: String,
    val estado: String,
    val fechaDenuncia: String,
    val fechaResolucion: String?,
    val entidadInvestigadora: String,
    val linkFuenteOficial: String,
    val gravedad: GravedadDenuncia
)

enum class GravedadDenuncia {
    ALTA, MEDIA, BAJA
}