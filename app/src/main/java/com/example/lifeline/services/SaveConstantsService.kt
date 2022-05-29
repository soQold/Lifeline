package com.example.lifeline.services

import com.example.lifeline.domain.common.LifelineResult
import com.example.lifeline.domain.usecases.constants.SavePressureUseCase
import com.example.lifeline.domain.usecases.constants.SavePulseUseCase
import com.example.lifeline.domain.usecases.constants.SaveSleepUseCase
import com.example.lifeline.domain.usecases.constants.SaveTemperatureUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SaveConstantsService(
    private val savePulseUseCase: SavePulseUseCase,
    private val savePressureUseCase: SavePressureUseCase,
    private val saveSleepUseCase: SaveSleepUseCase,
    private val saveTemperatureUseCase: SaveTemperatureUseCase
) {
    suspend fun savePulse(userId: Long, date: String, value: Int): LifelineResult<Boolean> {
        return withContext(Dispatchers.IO) { savePulseUseCase.invoke(userId, date, value) }
    }

    suspend fun savePressure(
        userId: Long,
        date: String,
        valueSys: Int,
        valueDia: Int
    ): LifelineResult<Boolean> {
        return withContext(Dispatchers.IO) {
            savePressureUseCase.invoke(
                userId,
                date,
                valueSys,
                valueDia
            )
        }
    }

    suspend fun saveSleep(userId: Long, date: String, value: Int): LifelineResult<Boolean> {
        return withContext(Dispatchers.IO) { saveSleepUseCase.invoke(userId, date, value) }
    }

    suspend fun saveTemperature(
        userId: Long,
        date: String,
        value: Double
    ): LifelineResult<Boolean> {
        return withContext(Dispatchers.IO) { saveTemperatureUseCase.invoke(userId, date, value) }
    }
}