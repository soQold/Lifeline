package com.example.lifeline.data.entities.request.constants

data class PulseRequest(
    val userId: Long,
    val date: String,
    val value: Int
)