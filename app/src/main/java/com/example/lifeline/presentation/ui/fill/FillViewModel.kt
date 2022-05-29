package com.example.lifeline.presentation.ui.fill

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifeline.services.CurrentUserService
import com.example.lifeline.services.SaveConstantsService
import com.example.lifeline.services.TokenService
import com.example.lifeline.utils.StringTransformer
import kotlinx.coroutines.launch
import java.util.*

class FillViewModel(
    private val currentUserService: CurrentUserService,
    private val saveConstantsService: SaveConstantsService,
    private val tokenService: TokenService
) : ViewModel() {
    private val token = tokenService.getAuthToken()
    val pulseLiveData = MutableLiveData("")
    val pressureSysLiveData = MutableLiveData("")
    val pressureDiaLiveData = MutableLiveData("")
    val temperatureLiveData = MutableLiveData("")
    val sleepLiveData = MutableLiveData("")

    fun saveData() {
        if (token != null) {
            savePressure()
            savePulse()
            //FIXME return when it will be ready
//            saveTemperature()
//            saveSleep()
        }
    }

    private fun savePulse() {
        viewModelScope.launch {
            val calendar = Calendar.getInstance()
            val pulse = StringTransformer.transformPulse(pulseLiveData.value!!) ?: return@launch
            saveConstantsService.savePulse(
                token!!,
                currentUserService.currentUser.value!!.id!!,
                calendar.time.toString(),
                pulse
            )
        }
    }

    private fun savePressure() {
        viewModelScope.launch {
            val calendar = Calendar.getInstance()
            val pressure =
                StringTransformer.transformPressure(pressureSysLiveData.value!!, pressureDiaLiveData.value!!) ?: return@launch
            saveConstantsService.savePressure(
                token!!,
                currentUserService.currentUser.value!!.id!!,
                calendar.time.toString(),
                pressure.first,
                pressure.second
            )
        }
    }

    private fun saveTemperature() {
        viewModelScope.launch {
            val calendar = Calendar.getInstance()
            val temperature =
                StringTransformer.transformTemperature(temperatureLiveData.value!!) ?: return@launch
            saveConstantsService.saveTemperature(
                token!!,
                currentUserService.currentUser.value!!.id!!,
                calendar.time.toString(),
                temperature
            )
        }
    }

    private fun saveSleep() {
        viewModelScope.launch {
            val calendar = Calendar.getInstance()
            val sleep = StringTransformer.transformSleep(sleepLiveData.value!!) ?: return@launch
            saveConstantsService.saveSleep(
                token!!,
                currentUserService.currentUser.value!!.id!!,
                calendar.time.toString(),
                sleep
            )
        }
    }
}