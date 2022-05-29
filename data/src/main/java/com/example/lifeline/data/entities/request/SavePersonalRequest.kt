package com.example.lifeline.data.entities.request

import com.google.gson.annotations.SerializedName

data class SavePersonalRequest(
    @SerializedName("full_name")
    var fullName: String? = null,
    var address: String? = null,
    var policy: String? = null
)