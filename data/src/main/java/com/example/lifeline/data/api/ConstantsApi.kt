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
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PUT

interface ConstantsApi {
    @GET("pulse")
    fun getPulse(@Header("Authorization") token: String): Response<PulseResponse>

    @PUT("pulse")
    fun savePulse(@Header("Authorization") token: String, @Body request: PulseRequest):Response<Void>

    @GET("pressure")
    fun getPressure(@Header("Authorization") token: String): Response<PressureResponse>

    @PUT("pressure")
    fun savePressure(@Header("Authorization") token: String, @Body request: PressureRequest):Response<Void>

    @GET("temperature")
    fun getTemperature(@Header("Authorization") token: String): Response<TemperatureResponse>

    @PUT("temperature")
    fun saveTemperature(@Header("Authorization") token: String, @Body request: TemperatureRequest):Response<Void>

    @GET("sleep")
    fun getSleep(@Header("Authorization") token: String): Response<SleepResponse>

    @PUT("sleep")
    fun saveSleep(@Header("Authorization") token: String, @Body request: SleepRequest):Response<Void>
}