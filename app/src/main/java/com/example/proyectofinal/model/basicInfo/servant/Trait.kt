package com.example.proyectofinal.model.basicInfo.servant

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Trait(
    val id: Int,
    val name: String
) : Parcelable