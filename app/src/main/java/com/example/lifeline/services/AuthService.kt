package com.example.lifeline.services

import com.example.lifeline.domain.common.LifelineResult
import com.example.lifeline.domain.entities.User
import com.example.lifeline.domain.usecases.auth.SignInUseCase
import com.example.lifeline.domain.usecases.auth.SignUpUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthService(private val signInUseCase: SignInUseCase, private val signUpUseCase: SignUpUseCase) {
    suspend fun signIn(username: String, password: String): LifelineResult<User>{
        return withContext(Dispatchers.IO){ signInUseCase.invoke(username, password) }
    }
    suspend fun signUp(username: String, password: String, email: String):LifelineResult<User>{
        return withContext(Dispatchers.IO){signUpUseCase.invoke(username, password, email)}
    }
}