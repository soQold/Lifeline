package com.example.lifeline.domain.usecases.constants

import com.example.lifeline.domain.repositories.ConstantsRepository

class SavePulseUseCase(private val constantsRepository: ConstantsRepository) {
    suspend operator fun invoke(token: String, userId: Long, date: String, value: Int) = constantsRepository.savePulse(token, userId, date, value)
}