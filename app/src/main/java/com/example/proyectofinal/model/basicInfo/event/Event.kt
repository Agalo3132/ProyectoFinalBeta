package com.example.proyectofinal.model.basicInfo.event

data class Event(
    val id: Int,
    val type: String,
    val name: String,
    val noticeAt: Int,
    val startedAt: Int,
    val endedAt: Int,
    val finishedAt: Int,
    val materialOpenedAt: Int,
    val warIds: List<Int>
)