package com.example.proyectofinal.model.basicInfo.war

import com.google.gson.annotations.SerializedName

data class RespuestaWar (

    @SerializedName("wars")
    val listaWar: List<War>
)