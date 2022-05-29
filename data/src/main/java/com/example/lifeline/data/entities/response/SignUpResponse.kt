package com.example.lifeline.data.entities.response

data class SignUpResponse(
    val id: Long,
    val username: String,
    val token: String,
    val status: Int
)
