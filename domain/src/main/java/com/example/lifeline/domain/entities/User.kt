package com.example.lifeline.domain.entities

data class User(
    var id: Long? = null,
    var username: String? = null,
    var email: String? = null,
    var personal: Personal = Personal(),
    var parameters: Parameters = Parameters(),
)