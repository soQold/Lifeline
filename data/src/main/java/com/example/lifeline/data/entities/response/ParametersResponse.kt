package com.example.lifeline.data.entities.response

import com.google.gson.annotations.SerializedName

data class ParametersResponse(
    @SerializedName("birth_date")
    val birthDate: String?,
    val gender: String?,
    val height: Int?,
    val weight: Double?
)
