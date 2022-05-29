package com.example.lifeline.data.repositories

import android.util.Log
import com.example.lifeline.data.api.NetworkModule
import com.example.lifeline.data.entities.request.SignInRequest
import com.example.lifeline.data.entities.request.SignUpRequest
import com.example.lifeline.data.mappers.AuthApiResponseMapper
import com.example.lifeline.data.utils.DataConstants
import com.example.lifeline.domain.common.LifelineResult
import com.example.lifeline.domain.entities.User
import com.example.lifeline.domain.repositories.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepositoryImpl(
    networkModule: NetworkModule,
    private val mapper: AuthApiResponseMapper
) : AuthRepository {
    private val api = networkModule.createAuthApi(DataConstants.baseAuthUrl)

    override suspend fun signIn(username: String, password: String): LifelineResult<User> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.signIn(SignInRequest(username, password))
                if (response.isSuccessful)
                    LifelineResult.Success(mapper.signInToUser(response.body()!!), response.body()!!.token)
                else
                    LifelineResult.Error(Exception())

            } catch (e: Exception) {
                LifelineResult.Error(e)
            }
        }
    }

    override suspend fun signUp(
        username: String,
        password: String,
        email: String
    ): LifelineResult<User> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.signUp(SignUpRequest(username, email, password))
                if (response.isSuccessful) {
                    return@withContext when (response.body()!!.status) {
                        200 -> LifelineResult.Success(mapper.signUpToUser(response.body()!!))
                        else -> LifelineResult.Error(Exception("${response.body()!!.status}"))
                    }
                } else
                    return@withContext LifelineResult.Error(Exception())
            } catch (e: Exception) {
                return@withContext LifelineResult.Error(Exception(e))
            }
        }
    }
}