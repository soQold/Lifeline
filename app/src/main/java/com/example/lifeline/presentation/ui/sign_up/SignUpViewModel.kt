package com.example.lifeline.presentation.ui.sign_up

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifeline.domain.common.LifelineResult
import com.example.lifeline.services.AuthService
import com.example.lifeline.services.CurrentUserService
import com.example.lifeline.services.UsersService
import com.example.lifeline.utils.StringValidator
import kotlinx.coroutines.launch
import timber.log.Timber

class SignUpViewModel(
    private val authService: AuthService,
    private val usersService: UsersService,
    private val currentUserService: CurrentUserService
) : ViewModel() {
    private val _step = MutableLiveData(1)
    val step: LiveData<Int> = _step
    val maxSteps = 3

    fun signUp(username: String, email: String, password: String, passwordConfirm: String) {
        when {
            !StringValidator.validateUsername(username) -> {
                Timber.e("Invalid username: $username")
                //FIXME show an error to user
            }
            !StringValidator.validateEmail(email) -> {
                Timber.e("Invalid email: $email")
                //FIXME show an error to user
            }
            !StringValidator.validatePassword(password) -> {
                Timber.e("Invalid password: $username")
                //FIXME show an error to user
            }
            password != passwordConfirm -> {
                Timber.e("Passwords doesn't match - password: $password; confirm: $passwordConfirm")
                //FIXME show an error to user
            }
            else -> {
                signUpByService(username, email, password)
            }
        }
    }

    private fun signUpByService(username: String, email: String, password: String) {
        viewModelScope.launch {
            when (val result = authService.signUp(username, password, email)) {
                is LifelineResult.Error -> {
                    Timber.e("Exception at response: ${result.exception.message}")
                    //FIXME show an error to user
                }
                is LifelineResult.Success -> {
                    Timber.i("User registered: ${result.data}")
                    currentUserService.setUser(result.data)
                    addStep()
                }
            }
        }
    }

    fun savePersonal(fullName: String, address: String, policy: String) {
        when {
            !StringValidator.validatePolicy(policy) -> {
                Timber.e("Invalid policy: $policy")
                //FIXME show an error to user
            }
            else -> {
                savePersonalByService(fullName, address, policy)
            }
        }
    }

    private fun savePersonalByService(fullName: String, address: String, policy: String) {
        viewModelScope.launch {
            when (val result = usersService.savePersonal(fullName, address, policy)) {
                is LifelineResult.Error -> {
                    Timber.e("Exception at response: ${result.exception.message}")
                    //FIXME show an error to user
                }
                is LifelineResult.Success -> {
                    Timber.i("Saved personal: ${result.data}")
                    addStep()
                }
            }
        }
    }

    fun saveParameters(
        birthDate: String, gender: String, height: String, weight: String
    ) {
        when {
            !StringValidator.validateBirthDate(birthDate) -> {
                Timber.e("Invalid birthDate: $birthDate")
                //FIXME show an error to user
            }
            !StringValidator.validateHeight(height) -> {
                Timber.e("Invalid height: $height")
                //FIXME show an error to user
            }
            !StringValidator.validateWeight(weight) -> {
                Timber.e("Invalid weight: $weight")
                //FIXME show an error to user
            }
            else -> {
                saveParametersByService(birthDate, gender, height.toInt(), weight.toDouble())
            }
        }
    }

    private fun saveParametersByService(birthDate: String, gender: String, height: Int, weight: Double){
        viewModelScope.launch {
            when (val result = usersService.saveParameters(birthDate, gender, height, weight)) {
                is LifelineResult.Error -> {
                    Timber.e("Exception at response: ${result.exception.message}")
                    //FIXME show an error to user
                }
                is LifelineResult.Success -> {
                    Timber.i("Saved parameters: ${result.data}")
                    addStep()
                }
            }
        }
    }

    private fun addStep() {
        _step.postValue(_step.value!! + 1)
    }
}