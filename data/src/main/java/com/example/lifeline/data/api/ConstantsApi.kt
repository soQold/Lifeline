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
import retrofit2.http.PUT

interface ConstantsApi {
    @GET("pulse")
    fun getPulse(): Response<PulseResponse>

    @PUT("pulse")
    fun savePulse(@Body request: PulseRequest):Response<Void>

    @GET("pressure")
    fun getPressure(): Response<PressureResponse>

    @PUT("pressure")
    fun savePressure(@Body request: PressureRequest):Response<Void>

    @GET("temperature")
    fun getTemperature(): Response<TemperatureResponse>

    @PUT("temperature")
    fun saveTemperature(@Body request: TemperatureRequest):Response<Void>

    @GET("sleep")
    fun getSleep(): Response<SleepResponse>

    @PUT("sleep")
    fun saveSleep(@Body request: SleepRequest):Response<Void>
}