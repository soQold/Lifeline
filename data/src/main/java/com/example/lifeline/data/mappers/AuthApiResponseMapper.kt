package com.example.lifeline.data.mappers

import com.example.lifeline.data.entities.response.SignInResponse
import com.example.lifeline.data.entities.response.SignUpResponse
import com.example.lifeline.domain.entities.User

class AuthApiResponseMapper {
    fun signInToUser(response: SignInResponse): User {
        return User(
            id=response.id,
            username = response.username
        )
    }

    fun signUpToUser(response: SignUpResponse): User {
        return User(
            id=response.id,
            username = response.username
        )
    }
}