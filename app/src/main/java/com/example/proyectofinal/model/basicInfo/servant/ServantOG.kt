package com.example.proyectofinal.model.basicInfo.servant

data class ServantOG(
    val id: Int,
    val collectionNo: Int,
    val name: String,
    val originalName: String,
    val overwriteName: String,
    val originalOverwriteName: String,
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
    val costume: Map<String, X1000100>
)