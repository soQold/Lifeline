package com.example.lifeline.domain.usecases.users

import com.example.lifeline.domain.repositories.UsersRepository

class SavePersonalUseCase(private val usersRepository: UsersRepository) {
    suspend operator fun invoke(fullName: String?, address: String?, policy: String?) =
        usersRepository.savePersonal(fullName, address, policy)
}