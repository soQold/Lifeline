package com.example.lifeline.domain.usecases.auth

import com.example.lifeline.domain.repositories.AuthRepository

class SignUpUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(username: String, password: String, email:String) = authRepository.signUp(username, password, email)
}