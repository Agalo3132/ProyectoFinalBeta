package com.example.proyectofinal.model.basicInfo.war

data class War(
    val id: Int,
    val coordinates: List<List<Double>>,
    val age: String,
    val name: String,
    val longName: String,
    val flags: List<String>,
    val eventId: Int,
    val eventName: String
)