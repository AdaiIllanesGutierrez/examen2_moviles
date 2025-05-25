package com.ucb.ucbtest.home.model

data class Plan(
    val nombre: String,
    val precioAntes: String,
    val precioAhora: String,
    val datos: String,
    val beneficios: List<String>
)
