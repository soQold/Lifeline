package com.example.lifeline.data.repositories

import com.example.lifeline.data.api.NetworkModule
import com.example.lifeline.data.entities.request.SavePersonalRequest
import com.example.lifeline.data.entities.request.constants.PressureRequest
import com.example.lifeline.data.entities.request.constants.PulseRequest
import com.example.lifeline.data.entities.request.constants.SleepRequest
import com.example.lifeline.data.entities.request.constants.TemperatureRequest
import com.example.lifeline.data.mappers.ConstantsApiMapper
import com.example.lifeline.data.utils.DataConstants
import com.example.lifeline.domain.common.LifelineResult
import com.example.lifeline.domain.entities.Personal
import com.example.lifeline.domain.entities.constants.Pressure
import com.example.lifeline.domain.entities.constants.Pulse
import com.example.lifeline.domain.entities.constants.Sleep
import com.example.lifeline.domain.entities.constants.Temperature
import com.example.lifeline.domain.repositories.ConstantsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ConstantsRepositoryImpl(
    networkModule: NetworkModule,
    private val mapper: ConstantsApiMapper
) : ConstantsRepository {
    private val api = networkModule.createConstantsApi(DataConstants.baseConstantsUrl)
    override suspend  fun getPulse(): LifelineResult<List<Pulse>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getPulse()

                if (response.isSuccessful)
                    LifelineResult.Success(mapper.pulseRemoteToLocalList(response.body()!!))
                else
                    LifelineResult.Error(Exception())

            } catch (e: Exception) {
                LifelineResult.Error(e)
            }
        }
    }

    override suspend fun savePulse(
        userId: Long,
        date: String,
        value: Int
    ): LifelineResult<Boolean> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.savePulse(PulseRequest(userId, date, value))

                if (response.isSuccessful)
                    LifelineResult.Success(true)
                else
                    LifelineResult.Error(Exception())

            } catch (e: Exception) {
                LifelineResult.Error(e)
            }
        }
    }

    override suspend  fun getPressure(): LifelineResult<List<Pressure>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getPressure()

                if (response.isSuccessful)
                    LifelineResult.Success(mapper.pressureRemoteToLocalList(response.body()!!))
                else
                    LifelineResult.Error(Exception())

            } catch (e: Exception) {
                LifelineResult.Error(e)
            }
        }
    }

    override suspend fun savePressure(
        userId: Long,
        date: String,
        valueSys: Int,
        valueDia: Int
    ): LifelineResult<Boolean> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.savePressure(PressureRequest(userId, date, valueSys, valueDia))

                if (response.isSuccessful)
                    LifelineResult.Success(true)
                else
                    LifelineResult.Error(Exception())

            } catch (e: Exception) {
                LifelineResult.Error(e)
            }
        }
    }

    override suspend  fun getTemperature(): LifelineResult<List<Temperature>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getTemperature()

                if (response.isSuccessful)
                    LifelineResult.Success(mapper.temperatureRemoteToLocalList(response.body()!!))
                else
                    LifelineResult.Error(Exception())

            } catch (e: Exception) {
                LifelineResult.Error(e)
            }
        }
    }

    override suspend fun saveTemperature(
        userId: Long,
        date: String,
        value: Double
    ): LifelineResult<Boolean> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.saveTemperature(TemperatureRequest(userId, date, value))

                if (response.isSuccessful)
                    LifelineResult.Success(true)
                else
                    LifelineResult.Error(Exception())

            } catch (e: Exception) {
                LifelineResult.Error(e)
            }
        }
    }

    override suspend fun getSleep(): LifelineResult<List<Sleep>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getSleep()

                if (response.isSuccessful)
                    LifelineResult.Success(mapper.sleepRemoteToLocalList(response.body()!!))
                else
                    LifelineResult.Error(Exception())

            } catch (e: Exception) {
                LifelineResult.Error(e)
            }
        }
    }

    override suspend fun saveSleep(
        userId: Long,
        date: String,
        value: Int
    ): LifelineResult<Boolean> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.saveSleep(SleepRequest(userId, date, value))

                if (response.isSuccessful)
                    LifelineResult.Success(true)
                else
                    LifelineResult.Error(Exception())

            } catch (e: Exception) {
                LifelineResult.Error(e)
            }
        }
    }
}