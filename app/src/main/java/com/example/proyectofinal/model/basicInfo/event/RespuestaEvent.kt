package com.example.proyectofinal.model.basicInfo.event

import com.google.gson.annotations.SerializedName

data class RespuestaEvent (

    @SerializedName("events")
    val listaEvent: List<Event>
)