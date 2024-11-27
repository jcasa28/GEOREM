package com.example.georem.data

data class Reminder(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val radius: Float,
    val time: Long? = null,
    var isCompleted: Boolean = false
)