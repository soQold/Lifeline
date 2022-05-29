package com.example.lifeline.data.entities.request

import com.example.lifeline.data.utils.DataConstants

data class SignInRequest(
    var username: String = DataConstants.emptyString,
    var password: String = DataConstants.emptyString
)