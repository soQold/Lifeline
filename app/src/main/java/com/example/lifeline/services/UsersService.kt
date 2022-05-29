package com.example.lifeline.services

import com.example.lifeline.domain.common.LifelineResult
import com.example.lifeline.domain.entities.Parameters
import com.example.lifeline.domain.entities.Personal
import com.example.lifeline.domain.usecases.users.GetParametersUseCase
import com.example.lifeline.domain.usecases.users.GetPersonalUseCase
import com.example.lifeline.domain.usecases.users.SaveParametersUseCase
import com.example.lifeline.domain.usecases.users.SavePersonalUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UsersService(
    private val getPersonalUseCase: GetPersonalUseCase,
    private val savePersonalUseCase: SavePersonalUseCase,
    private val getParametersUseCase: GetParametersUseCase,
    private val saveParametersUseCase: SaveParametersUseCase
) {
    suspend fun getPersonal(): LifelineResult<Personal> {
        return withContext(Dispatchers.IO) { getPersonalUseCase.invoke() }
    }

    suspend fun savePersonal(
        fullName: String?,
        address: String?,
        policy: String?
    ): LifelineResult<Personal> {
        return withContext(Dispatchers.IO) { savePersonalUseCase.invoke(fullName, address, policy) }
    }

    suspend fun getParameters(): LifelineResult<Parameters> {
        return withContext(Dispatchers.IO) { getParametersUseCase.invoke() }
    }

    suspend fun saveParameters(
        birthDate: String?, gender: String?, height: Int?, weight: Double?
    ): LifelineResult<Parameters> {
        return withContext(Dispatchers.IO) {
            saveParametersUseCase.invoke(
                birthDate,
                gender,
                height,
                weight
            )
        }
    }
}