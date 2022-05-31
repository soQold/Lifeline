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
import retrofit2.http.Path

class ConstantsRepositoryImpl(
    networkModule: NetworkModule,
    private val mapper: ConstantsApiMapper
) : ConstantsRepository {
    private val api = networkModule.createConstantsApi(DataConstants.baseConstantsUrl)
    override suspend  fun getPulse(token: String, userId: Long): LifelineResult<List<Pulse>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getPulse(token, userId)

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
        token: String,
        userId: Long,
        date: String,
        value: Int
    ): LifelineResult<Boolean> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.savePulse(token, PulseRequest(userId, date, value))

                if (response.isSuccessful)
                    LifelineResult.Success(true)
                else
                    LifelineResult.Error(Exception())

            } catch (e: Exception) {
                LifelineResult.Error(e)
            }
        }
    }

    override suspend  fun getPressure(token: String, userId: Long): LifelineResult<List<Pressure>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getPressure(token, userId)

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
        token: String,
        userId: Long,
        date: String,
        valueSys: Int,
        valueDia: Int
    ): LifelineResult<Boolean> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.savePressure(token, PressureRequest(userId, date, valueSys, valueDia))

                if (response.isSuccessful)
                    LifelineResult.Success(true)
                else
                    LifelineResult.Error(Exception())

            } catch (e: Exception) {
                LifelineResult.Error(e)
            }
        }
    }

    override suspend  fun getTemperature(token: String, userId: Long): LifelineResult<List<Temperature>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getTemperature(token, userId)

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
        token: String,
        userId: Long,
        date: String,
        value: Double
    ): LifelineResult<Boolean> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.saveTemperature(token, TemperatureRequest(userId, date, value))

                if (response.isSuccessful)
                    LifelineResult.Success(true)
                else
                    LifelineResult.Error(Exception())

            } catch (e: Exception) {
                LifelineResult.Error(e)
            }
        }
    }

    override suspend fun getSleep(token: String, userId: Long): LifelineResult<List<Sleep>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getSleep(token, userId)

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
        token: String,
        userId: Long,
        date: String,
        value: Int
    ): LifelineResult<Boolean> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.saveSleep(token, SleepRequest(userId, date, value))

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