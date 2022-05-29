package com.example.lifeline.domain.repositories

import com.example.lifeline.domain.common.LifelineResult
import com.example.lifeline.domain.entities.User

interface AuthRepository {
    suspend fun signIn(username: String, password: String):LifelineResult<User>

    suspend fun signUp(username: String, password: String, email: String): LifelineResult<User>
}