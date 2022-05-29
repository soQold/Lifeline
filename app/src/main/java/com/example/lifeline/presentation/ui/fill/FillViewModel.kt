package com.example.lifeline.presentation.ui.fill

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifeline.domain.common.LifelineResult
import com.example.lifeline.services.CurrentUserService
import com.example.lifeline.services.GetConstantsService
import com.example.lifeline.services.SaveConstantsService
import com.example.lifeline.utils.StringTransformer
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*

class FillViewModel(
    private val currentUserService: CurrentUserService,
    private val saveConstantsService: SaveConstantsService,
) : ViewModel() {
    val pulseLiveData = MutableLiveData("")
    val pressureLiveData = MutableLiveData("")
    val temperatureLiveData = MutableLiveData("")
    val sleepLiveData = MutableLiveData("")

    fun saveData(){
        savePressure()
        savePulse()
        saveTemperature()
        saveSleep()
    }

    private fun savePulse(){
        viewModelScope.launch {
            val calendar = Calendar.getInstance()
            val pulse = StringTransformer.transformPulse(pulseLiveData.value!!)
            if (pulse != null)
                saveConstantsService.savePulse(
                    currentUserService.currentUser.value!!.id!!,
                    calendar.time.toString(),
                    pulse
                )
        }
    }

    private fun savePressure(){
        viewModelScope.launch {
            val calendar = Calendar.getInstance()
            val pressure = StringTransformer.transformPressure(pressureLiveData.value!!)
            if (pressure != null)
                saveConstantsService.savePressure(
                    currentUserService.currentUser.value!!.id!!,
                    calendar.time.toString(),
                    pressure.first,
                    pressure.second
                )
        }
    }

    private fun saveTemperature(){
        viewModelScope.launch {
            val calendar = Calendar.getInstance()
            val temperature = StringTransformer.transformTemperature(temperatureLiveData.value!!)
            if (temperature != null)
                saveConstantsService.saveTemperature(
                    currentUserService.currentUser.value!!.id!!,
                    calendar.time.toString(),
                    temperature
                )
        }
    }

    private fun saveSleep(){
        viewModelScope.launch {
            val calendar = Calendar.getInstance()
            val sleep = StringTransformer.transformSleep(sleepLiveData.value!!)
            if (sleep != null)
                saveConstantsService.saveSleep(
                    currentUserService.currentUser.value!!.id!!,
                    calendar.time.toString(),
                    sleep
                )
        }
    }
}