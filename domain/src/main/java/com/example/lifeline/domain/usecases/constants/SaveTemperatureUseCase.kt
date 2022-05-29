package com.example.lifeline.domain.usecases.constants

import com.example.lifeline.domain.repositories.ConstantsRepository

class SaveTemperatureUseCase(private val constantsRepository: ConstantsRepository) {
    suspend operator fun invoke(userId: Long, date: String, value: Double) = constantsRepository.saveTemperature(userId, date, value)
}