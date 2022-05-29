package com.example.lifeline.data.repositories

import com.example.lifeline.data.api.NetworkModule
import com.example.lifeline.data.entities.request.SaveParametersRequest
import com.example.lifeline.data.entities.request.SavePersonalRequest
import com.example.lifeline.data.mappers.UsersApiMapper
import com.example.lifeline.data.utils.DataConstants
import com.example.lifeline.domain.common.LifelineResult
import com.example.lifeline.domain.entities.Parameters
import com.example.lifeline.domain.entities.Personal
import com.example.lifeline.domain.repositories.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UsersRepositoryImpl(
    networkModule: NetworkModule,
    private val mapper: UsersApiMapper
) : UsersRepository {
    private val api = networkModule.createUsersApi(DataConstants.baseUsersUrl)
    override suspend fun savePersonal(
        fullName: String?,
        address: String?,
        policy: String?
    ): LifelineResult<Personal> {
        //FIXME remove this, return normal request
        return LifelineResult.Success(
            Personal("Mr Qold", "КубГУ", null)
        )

        return withContext(Dispatchers.IO) {
            try {
                val response = api.savePersonal(SavePersonalRequest(fullName, address, policy))

                if (response.isSuccessful)
                    LifelineResult.Success(mapper.personalRemoteToLocal(response.body()!!))
                else
                    LifelineResult.Error(Exception())

            } catch (e: Exception) {
                LifelineResult.Error(e)
            }
        }
    }

    override suspend fun getPersonal(): LifelineResult<Personal> {
        //FIXME remove this, return normal request
        return LifelineResult.Success(
            Personal("Mr Qold", "КубГУ", null)
        )

        return withContext(Dispatchers.IO) {
            try {
                val response = api.getPersonal()

                if (response.isSuccessful)
                    LifelineResult.Success(mapper.personalRemoteToLocal(response.body()!!))
                else
                    LifelineResult.Error(Exception())

            } catch (e: Exception) {
                LifelineResult.Error(e)
            }
        }
    }

    override suspend fun saveParameters(
        birthDate: String?,
        gender: String?,
        height: Int?,
        weight: Double?
    ): LifelineResult<Parameters> {
        //FIXME remove this, return normal request
        return LifelineResult.Success(
            Parameters("18/05/2000", "male", 193, 78.7)
        )

        return withContext(Dispatchers.IO) {
            try {
                val response = api.saveParameters(SaveParametersRequest(birthDate, gender, height, weight))

                if (response.isSuccessful)
                    LifelineResult.Success(mapper.parametersRemoteToLocal(response.body()!!))
                else
                    LifelineResult.Error(Exception())

            } catch (e: Exception) {
                LifelineResult.Error(e)
            }
        }
    }

    override suspend fun getParameters(): LifelineResult<Parameters> {
        //FIXME remove this, return normal request
        return LifelineResult.Success(
            Parameters("18/05/2000", "male", 193, 78.7)
        )

        return withContext(Dispatchers.IO) {
            try {
                val response = api.getParameters()

                if (response.isSuccessful)
                    LifelineResult.Success(mapper.parametersRemoteToLocal(response.body()!!))
                else
                    LifelineResult.Error(Exception())

            } catch (e: Exception) {
                LifelineResult.Error(e)
            }
        }
    }
}