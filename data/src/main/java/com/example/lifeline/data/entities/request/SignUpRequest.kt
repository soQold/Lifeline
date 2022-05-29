package com.example.lifeline.data.entities.request

import com.example.lifeline.data.utils.DataConstants

data class SignUpRequest(
    var username: String = DataConstants.emptyString,
    var email: String = DataConstants.emptyString,
    var password: String = DataConstants.emptyString
)