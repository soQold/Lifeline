package com.example.lifeline.data.entities.request

import com.google.gson.annotations.SerializedName

data class SaveParametersRequest(
    @SerializedName("birth_date")
    var birthDate: String? = null,
    var gender: String? = null,
    var height: Int? = null,
    var weight: Double? = null
)