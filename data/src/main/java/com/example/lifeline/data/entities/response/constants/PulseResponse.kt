package com.example.lifeline.data.entities.response.constants

data class PulseResponse(
    val data: List<SinglePulseResponse>
){
    data class SinglePulseResponse(
        val userId: Long,
        val date: String,
        val value: Int
    )
}