package com.example.lifeline.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkModule {
    private val loggingInterceptor by lazy {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        loggingInterceptor
    }

    private val httpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    private fun getClient(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun createAuthApi(baseUrl: String): AuthApi{
        val client = getClient(baseUrl)
        return client.create(AuthApi::class.java)
    }

    fun createUsersApi(baseUrl: String): UsersApi{
        val client = getClient(baseUrl)
        return client.create(UsersApi::class.java)
    }

    fun createConstantsApi(baseUrl: String): ConstantsApi{
        val client = getClient(baseUrl)
        return client.create(ConstantsApi::class.java)
    }
}