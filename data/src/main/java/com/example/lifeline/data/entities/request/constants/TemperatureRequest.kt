package com.example.lifeline.data.entities.request.constants

data class TemperatureRequest(
    val userId: Long,
    val date: String,
    val value: Double
)
