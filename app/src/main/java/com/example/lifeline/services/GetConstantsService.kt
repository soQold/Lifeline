package com.example.lifeline.services

import com.example.lifeline.domain.common.LifelineResult
import com.example.lifeline.domain.entities.constants.Pressure
import com.example.lifeline.domain.entities.constants.Pulse
import com.example.lifeline.domain.entities.constants.Sleep
import com.example.lifeline.domain.entities.constants.Temperature
import com.example.lifeline.domain.usecases.constants.GetPressureUseCase
import com.example.lifeline.domain.usecases.constants.GetPulseUseCase
import com.example.lifeline.domain.usecases.constants.GetSleepUseCase
import com.example.lifeline.domain.usecases.constants.GetTemperatureUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetConstantsService(
    private val getPulseUseCase: GetPulseUseCase,
    private val getPressureUseCase: GetPressureUseCase,
    private val getSleepUseCase: GetSleepUseCase,
    private val getTemperatureUseCase: GetTemperatureUseCase
) {
    suspend fun getPulse():LifelineResult<List<Pulse>>{
        return withContext(Dispatchers.IO) {getPulseUseCase.invoke()}
    }

    suspend fun getPressure(): LifelineResult<List<Pressure>>{
        return withContext(Dispatchers.IO) {getPressureUseCase.invoke()}
    }

    suspend fun getSleep(): LifelineResult<List<Sleep>>{
        return withContext(Dispatchers.IO) {getSleepUseCase.invoke()}
    }

    suspend fun getTemperature(): LifelineResult<List<Temperature>>{
        return withContext(Dispatchers.IO) {getTemperatureUseCase.invoke()}
    }
}