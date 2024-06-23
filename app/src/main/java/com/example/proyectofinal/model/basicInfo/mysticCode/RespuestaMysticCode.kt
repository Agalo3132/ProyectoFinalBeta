package com.example.proyectofinal.model.basicInfo.mysticCode

import com.google.gson.annotations.SerializedName

data class RespuestaMysticCode (

    @SerializedName("mysticCodes")
    val listaMysticCode: List<MysticCode>
)