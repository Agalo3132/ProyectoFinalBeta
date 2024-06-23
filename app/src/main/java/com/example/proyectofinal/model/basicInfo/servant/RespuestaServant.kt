package com.example.proyectofinal.model.basicInfo.servant

import com.google.gson.annotations.SerializedName

data class RespuestaServant (

    @SerializedName("servants")
    val listaServants: List<Servant>
)


