package com.example.lifeline.data.entities.request.constants

import com.google.gson.annotations.SerializedName

data class PulseRequest(
    @SerializedName("user_id")
    val userId: Long,
    @SerializedName("date_time")
    val date: String,
    @SerializedName("pulse")
    val value: Int
)