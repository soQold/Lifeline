package com.example.lifeline.presentation.ui.sign_in

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifeline.domain.common.LifelineResult
import com.example.lifeline.services.AuthService
import com.example.lifeline.services.CurrentUserService
import com.example.lifeline.services.TokenService
import com.example.lifeline.utils.StringValidator
import kotlinx.coroutines.launch
import timber.log.Timber

class SignInViewModel(
    private val authService: AuthService,
    private val currentUserService: CurrentUserService,
    private val tokenService: TokenService
) : ViewModel() {
    private val _authResult = MutableLiveData<SignInResults?>()
    val authResult: LiveData<SignInResults?> = _authResult
    fun signIn(username: String, password: String) {
        when {
            !StringValidator.validateUsernameOrEmail(username) -> {
                Timber.e("Invalid username: $username")
                _authResult.postValue(SignInResults.USERNAME_ERROR)
            }
            !StringValidator.validatePassword(password) -> {
                Timber.e("Invalid password: $password")
                _authResult.postValue(SignInResults.PASSWORD_ERROR)
            }
            else -> {
                signInByService(username, password)
            }
        }
    }

    private fun signInByService(username: String, password: String) {
        viewModelScope.launch {
            when (val result = authService.signIn(username, password)) {
                is LifelineResult.Error -> {
                    Timber.e("Exception at response: ${result.exception.message}")
                    _authResult.postValue(SignInResults.RESPONSE_ERROR)
                }
                is LifelineResult.Success -> {
                    if(result.token == null) {
                        Timber.e("User not logged in, token is null")
                        _authResult.postValue(SignInResults.TOKEN_ERROR)
                    }
                    else {
                        Timber.i("User logged in: ${result.data} with token: ${result.token}")
                        currentUserService.setUser(result.data)
                        tokenService.setAuthToken(result.token!!)
                        _authResult.postValue(SignInResults.SUCCESS)
                    }
                }
            }
        }
    }
}