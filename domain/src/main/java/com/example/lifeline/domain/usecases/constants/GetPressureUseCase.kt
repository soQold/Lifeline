package com.example.lifeline.domain.usecases.constants

import com.example.lifeline.domain.repositories.ConstantsRepository

class GetPressureUseCase (private val constantsRepository: ConstantsRepository) {
    suspend operator fun invoke(token: String, userId: Long) = constantsRepository.getPressure(token, userId)
}