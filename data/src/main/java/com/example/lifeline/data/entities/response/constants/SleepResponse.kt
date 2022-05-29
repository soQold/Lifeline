package com.example.lifeline.data.entities.response.constants

data class SleepResponse(
    val data: List<SingleSleepResponse>
){
    data class SingleSleepResponse(
        val userId: Long,
        val date: String,
        val value: Int
    )
}
