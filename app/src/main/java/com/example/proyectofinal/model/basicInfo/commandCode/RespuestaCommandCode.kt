package com.example.proyectofinal.model.basicInfo.commandCode

import com.google.gson.annotations.SerializedName

data class RespuestaCommandCode (
    @SerializedName("commandCodes")
    val listaCommandCode: List<CommandCode>
)