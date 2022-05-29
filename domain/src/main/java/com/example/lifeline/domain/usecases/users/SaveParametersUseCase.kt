package com.example.lifeline.domain.usecases.users

import com.example.lifeline.domain.repositories.UsersRepository

class SaveParametersUseCase(private val usersRepository: UsersRepository) {
    suspend operator fun invoke(
        birthDate: String?,
        gender: String?,
        height: Int?,
        weight: Double?
    ) = usersRepository.saveParameters(birthDate, gender, height, weight)
}