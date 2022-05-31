package com.example.lifeline.data.entities.response.constants

import com.google.gson.annotations.SerializedName

data class TemperatureResponse(
    @SerializedName("user_id")
    val userId: Long,
    @SerializedName("date_time")
    val date: String,
    @SerializedName("temperature")
    val value: Double
    )