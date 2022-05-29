package com.example.lifeline.domain.usecases.constants

import com.example.lifeline.domain.repositories.ConstantsRepository

class SavePressureUseCase (private val constantsRepository: ConstantsRepository) {
    suspend operator fun invoke(userId: Long, date: String, valueSys: Int, valueDia: Int) = constantsRepository.savePressure(userId, date, valueSys, valueDia)
}