package com.example.lifeline.presentation.ui.fill

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifeline.services.CurrentUserService
import com.example.lifeline.services.SaveConstantsService
import com.example.lifeline.services.TokenService
import com.example.lifeline.utils.StringTransformer
import kotlinx.coroutines.launch
import timber.log.Timber
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
        Timber.i("Saving data with token: $token")
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
            Timber.i("Saving pulse: ${pulseLiveData.value}")
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
            Timber.i("Saving pressure: ${pressureSysLiveData.value}/${pressureDiaLiveData.value}")
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
            Timber.i("Saving temperature: ${temperatureLiveData.value}")
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
            Timber.i("Saving sleep: ${sleepLiveData.value}")
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