package com.example.lifeline.services

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lifeline.domain.entities.User

class CurrentUserService {
    private val _currentUser = MutableLiveData<User>()
    val currentUser: LiveData<User> = _currentUser

    fun setUser(user: User){
        _currentUser.postValue(user)
    }
}