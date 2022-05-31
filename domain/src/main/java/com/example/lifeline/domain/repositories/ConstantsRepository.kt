package com.example.lifeline.domain.repositories

import com.example.lifeline.domain.common.LifelineResult
import com.example.lifeline.domain.entities.constants.Pressure
import com.example.lifeline.domain.entities.constants.Pulse
import com.example.lifeline.domain.entities.constants.Sleep
import com.example.lifeline.domain.entities.constants.Temperature

interface ConstantsRepository {
    suspend fun getPulse(token: String, userId: Long): LifelineResult<List<Pulse>>

    suspend fun savePulse(token: String, userId: Long, date: String, value: Int): LifelineResult<Boolean>

    suspend fun getPressure(token: String, userId: Long): LifelineResult<List<Pressure>>

    suspend fun savePressure(token: String, userId: Long, date: String, valueSys: Int, valueDia: Int): LifelineResult<Boolean>

    suspend fun getTemperature(token: String, userId: Long): LifelineResult<List<Temperature>>

    suspend fun saveTemperature(token: String, userId: Long, date: String, value: Double): LifelineResult<Boolean>

    suspend fun getSleep(token: String, userId: Long): LifelineResult<List<Sleep>>

    suspend fun saveSleep(token: String, userId: Long, date: String, value: Int): LifelineResult<Boolean>
}