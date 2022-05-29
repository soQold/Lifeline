package com.example.lifeline.domain.usecases.users

import com.example.lifeline.domain.repositories.UsersRepository

class GetPersonalUseCase(private val usersRepository: UsersRepository) {
    suspend operator fun invoke() = usersRepository.getPersonal()
}