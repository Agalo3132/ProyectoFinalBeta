package com.example.proyectofinal.model.basicInfo.commandCode

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CommandCode(
    val id: Int,
    val collectionNo: Int,
    val name: String,
    val rarity: Int,
    val face: String
) :Parcelable