package com.example.lifeline.domain.repositories

import com.example.lifeline.domain.common.LifelineResult
import com.example.lifeline.domain.entities.constants.Pressure
import com.example.lifeline.domain.entities.constants.Pulse
import com.example.lifeline.domain.entities.constants.Sleep
import com.example.lifeline.domain.entities.constants.Temperature

interface ConstantsRepository {
    suspend fun getPulse(): LifelineResult<List<Pulse>>

    suspend fun savePulse(userId: Long, date: String, value: Int): LifelineResult<Boolean>

    suspend fun getPressure(): LifelineResult<List<Pressure>>

    suspend fun savePressure(userId: Long, date: String, valueSys: Int, valueDia: Int): LifelineResult<Boolean>

    suspend fun getTemperature(): LifelineResult<List<Temperature>>

    suspend fun saveTemperature(userId: Long, date: String, value: Double): LifelineResult<Boolean>

    suspend fun getSleep(): LifelineResult<List<Sleep>>

    suspend fun saveSleep(userId: Long, date: String, value: Int): LifelineResult<Boolean>
}