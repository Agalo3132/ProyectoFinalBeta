package com.example.proyectofinal.model.basicInfo.craftEssence

data class CraftEssence(
    val id: Int,
    val collectionNo: Int,
    val name: String,
    val originalName: String,
    val type: String,
    val flag: String,
    val flags: List<String>,
    val rarity: Int,
    val atkMax: Int,
    val hpMax: Int,
    val face: String,
    val bondEquipOwner: Int,
    val valentineEquipOwner: Int
)