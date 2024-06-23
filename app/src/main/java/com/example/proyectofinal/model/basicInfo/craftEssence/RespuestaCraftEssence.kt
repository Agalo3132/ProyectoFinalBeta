package com.example.proyectofinal.model.basicInfo.craftEssence

import com.google.gson.annotations.SerializedName

data class RespuestaCraftEssence (

    @SerializedName("essences")
    val listaCraftEssence: List<CraftEssence>

)