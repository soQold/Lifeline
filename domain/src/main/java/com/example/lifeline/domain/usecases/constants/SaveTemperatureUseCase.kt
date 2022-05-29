package com.example.lifeline.domain.usecases.constants

import com.example.lifeline.domain.repositories.ConstantsRepository

class SaveTemperatureUseCase(private val constantsRepository: ConstantsRepository) {
    suspend operator fun invoke(token: String, userId: Long, date: String, value: Double) = constantsRepository.saveTemperature(token, userId, date, value)
}