package com.example.lifeline.domain.usecases.constants

import com.example.lifeline.domain.repositories.ConstantsRepository

class SaveSleepUseCase(private val constantsRepository: ConstantsRepository) {
    suspend operator fun invoke(token: String, userId: Long, date: String, value: String) = constantsRepository.saveSleep(token, userId, date, value)
}