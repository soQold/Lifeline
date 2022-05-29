package com.example.lifeline.data.api

import com.example.lifeline.data.entities.request.SaveParametersRequest
import com.example.lifeline.data.entities.request.SavePersonalRequest
import com.example.lifeline.data.entities.response.ParametersResponse
import com.example.lifeline.data.entities.response.PersonalResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT

interface UsersApi {
    @PUT("personal")
    fun savePersonal(@Body request: SavePersonalRequest): Response<PersonalResponse>

    @GET("personal")
    fun getPersonal(): Response<PersonalResponse>

    @PUT("parameters")
    fun saveParameters(@Body request: SaveParametersRequest): Response<ParametersResponse>

    @GET("parameters")
    fun getParameters(): Response<ParametersResponse>
}