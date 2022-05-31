package com.example.lifeline.data.entities.request.constants

import com.google.gson.annotations.SerializedName

data class PressureRequest(
    @SerializedName("user_id")
    val userId: Long,
    @SerializedName("date_time")
    val date: String,
    @SerializedName("systolic")
    val valueSystolic: Int,
    @SerializedName("diastolic")
    val valueDiastolic: Int
)