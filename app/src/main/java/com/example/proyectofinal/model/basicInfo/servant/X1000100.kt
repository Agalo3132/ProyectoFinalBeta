package com.example.proyectofinal.model.basicInfo.servant

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class X1000100(
    /**
    val id: Int,
    val costumeCollectionNo: Int,
    val battleCharaId: Int,
    val shortName: String
    **/

    val costumeId: Int,
    val name: String,
    val shortName: String,
    val detail: String,
    val condQuestId: Int,
    val condQuestName: String,
    val condQuestPhase: Int

) : Parcelable