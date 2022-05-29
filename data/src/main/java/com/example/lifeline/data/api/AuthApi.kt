package com.example.lifeline.data.api

import com.example.lifeline.data.entities.request.SignInRequest
import com.example.lifeline.data.entities.request.SignUpRequest
import com.example.lifeline.data.entities.response.SignInResponse
import com.example.lifeline.data.entities.response.SignUpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

//FIXME make endpoints
interface AuthApi {
    @POST("login")
    suspend fun signIn(@Body request: SignInRequest): Response<SignInResponse>

    @POST("register")
    suspend fun signUp(@Body request: SignUpRequest): Response<SignUpResponse>
}