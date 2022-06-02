package com.example.lifeline.data.api

import com.example.lifeline.data.entities.request.constants.PressureRequest
import com.example.lifeline.data.entities.request.constants.PulseRequest
import com.example.lifeline.data.entities.request.constants.SleepRequest
import com.example.lifeline.data.entities.request.constants.TemperatureRequest
import com.example.lifeline.data.entities.response.constants.PressureResponse
import com.example.lifeline.data.entities.response.constants.PulseResponse
import com.example.lifeline.data.entities.response.constants.SleepResponse
import com.example.lifeline.data.entities.response.constants.TemperatureResponse
import retrofit2.Response
import retrofit2.http.*

interface ConstantsApi {
    @GET("pulse/{id}")
    suspend fun getPulse(@Header("Authorization") token: String, @Path("id") userId: Long): Response<List<PulseResponse>>

    @POST("pulse")
    suspend fun savePulse(@Header("Authorization") token: String, @Body request: PulseRequest):Response<Void>

    @GET("pressure/{id}")
    suspend fun getPressure(@Header("Authorization") token: String, @Path("id") userId: Long): Response<List<PressureResponse>>

    @POST("pressure")
    suspend fun savePressure(@Header("Authorization") token: String, @Body request: PressureRequest):Response<Void>

    @GET("temperature/{id}")
    suspend fun getTemperature(@Header("Authorization") token: String, @Path("id") userId: Long): Response<List<TemperatureResponse>>

    @POST("temperature")
    suspend fun saveTemperature(@Header("Authorization") token: String, @Body request: TemperatureRequest):Response<Void>

    @GET("sleep/{id}")
    suspend fun getSleep(@Header("Authorization") token: String, @Path("id") userId: Long): Response<List<SleepResponse>>

    @POST("sleep")
    suspend fun saveSleep(@Header("Authorization") token: String, @Body request: SleepRequest):Response<Void>
}