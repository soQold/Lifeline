package com.example.lifeline.data.entities.request.constants

data class PressureRequest(
    val userId: Long,
    val date: String,
    val valueSystolic: Int,
    val valueDiastolic: Int
)