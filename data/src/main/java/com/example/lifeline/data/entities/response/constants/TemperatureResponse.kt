package com.example.lifeline.data.entities.response.constants

data class TemperatureResponse(
    val data: List<SingleTemperatureResponse>
    ){
    data class SingleTemperatureResponse(
        val userId: Long,
        val date: String,
        val value: Double
        )
}
