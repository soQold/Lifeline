package com.example.lifeline.domain.repositories

import com.example.lifeline.domain.common.LifelineResult
import com.example.lifeline.domain.entities.Parameters
import com.example.lifeline.domain.entities.Personal

interface UsersRepository {
    suspend fun savePersonal(
        fullName: String?,
        address: String?,
        policy: String?
    ): LifelineResult<Personal>

    suspend fun getPersonal(): LifelineResult<Personal>

    suspend fun saveParameters(
        birthDate: String?,
        gender: String?,
        height: Int?,
        weight: Double?
    ): LifelineResult<Parameters>

    suspend fun getParameters(): LifelineResult<Parameters>
}