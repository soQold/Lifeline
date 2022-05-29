package com.example.lifeline.data.mappers

import com.example.lifeline.data.entities.response.ParametersResponse
import com.example.lifeline.data.entities.response.PersonalResponse
import com.example.lifeline.domain.entities.Parameters
import com.example.lifeline.domain.entities.Personal

class UsersApiMapper {
    fun parametersRemoteToLocal(response: ParametersResponse): Parameters{
        return Parameters(
            response.birthDate,
            response.gender,
            response.height,
            response.weight
        )
    }

    fun personalRemoteToLocal(response: PersonalResponse): Personal{
        return Personal(
            response.fullName,
            response.address,
            response.policy
        )
    }
}