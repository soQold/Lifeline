package com.example.lifeline.data.entities.response.constants

data class PressureResponse(
    val data: List<SinglePressureResponse>
){
    data class SinglePressureResponse(
        val userId: Long,
        val date: String,
        val valueSystolic: Int,
        val valueDiastolic: Int
    )
}