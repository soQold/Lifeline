package com.example.lifeline.domain.usecases.constants

import com.example.lifeline.domain.repositories.ConstantsRepository

class GetSleepUseCase (private val constantsRepository: ConstantsRepository) {
    suspend operator fun invoke(token: String, userId: Long) = constantsRepository.getSleep(token, userId)
}