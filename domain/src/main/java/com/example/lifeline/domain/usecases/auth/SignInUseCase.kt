package com.example.lifeline.domain.usecases.auth

import com.example.lifeline.domain.repositories.AuthRepository

class SignInUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(username: String, password: String) = authRepository.signIn(username, password)
}