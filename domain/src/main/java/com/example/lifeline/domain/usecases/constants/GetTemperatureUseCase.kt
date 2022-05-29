package com.example.lifeline.domain.usecases.constants

import com.example.lifeline.domain.repositories.ConstantsRepository

class GetTemperatureUseCase (private val constantsRepository: ConstantsRepository) {
    suspend operator fun invoke(token: String, ) = constantsRepository.getTemperature(token)
}