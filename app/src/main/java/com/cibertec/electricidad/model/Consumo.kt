package com.cibertec.electricidad.model

data class Consumo(
    val id: Int = 0,
    val cliente: String,
    val kilovatios: Int,
    val suministro: String,
    val conexion: String,
    val importeTotal: Double
)
