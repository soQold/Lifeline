package com.example.lifeline.data.entities.response

import com.google.gson.annotations.SerializedName

data class PersonalResponse(
    @SerializedName("full_name")
    val fullName: String?,
    val address: String?,
    val policy: String?
)