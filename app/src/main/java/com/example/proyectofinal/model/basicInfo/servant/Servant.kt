package com.example.proyectofinal.model.basicInfo.servant

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

//QUITAR PARCELIZE Y PARCELABLE SI NO VA

@Parcelize
data class Servant(
    val id: Int,
    val collectionNo: Int,
    val name: String,
    val originalName: String,
    val overwriteName: String? = null,
    val originalOverwriteName: String? = null,
    val type: String,
    val flag: String,
    val flags: List<String>,
    val classId: Int,
    val className: String,
    val attribute: String,
    val traits: List<Trait>,
    val rarity: Int,
    val atkMax: Int,
    val hpMax: Int,
    val face: String,
    val costume: Map<String, X1000100>, //NO BORRAR ORIGINAL SI VES QUE NO VA VUELVE A ESTE Y BORRA EL DE ABAJO
    //val costume: Map<String, Costume>,
    val imageUrl: String?
) : Parcelable
