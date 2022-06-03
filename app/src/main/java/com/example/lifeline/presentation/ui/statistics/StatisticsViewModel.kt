package com.example.lifeline.presentation.ui.statistics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifeline.domain.common.LifelineResult
import com.example.lifeline.domain.entities.constants.Pressure
import com.example.lifeline.domain.entities.constants.Pulse
import com.example.lifeline.domain.entities.constants.Sleep
import com.example.lifeline.domain.entities.constants.Temperature
import com.example.lifeline.entities.ChartData
import com.example.lifeline.services.ChartService
import com.example.lifeline.services.CurrentUserService
import com.example.lifeline.services.GetConstantsService
import com.example.lifeline.services.TokenService
import com.example.lifeline.utils.DateFormatter
import com.github.mikephil.charting.charts.LineChart
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*

class StatisticsViewModel(
    private val currentUserService: CurrentUserService,
    private val getConstantsService: GetConstantsService,
    private val chartService: ChartService,
    tokenService: TokenService
) : ViewModel() {
    private val token = tokenService.getAuthToken()
    private val _pulseLiveData = MutableLiveData<List<Pulse>>(listOf())
    val pulseLiveData: LiveData<List<Pulse>> = _pulseLiveData

    private val _pressureLiveData = MutableLiveData<List<Pressure>>(listOf())
    val pressureLiveData: LiveData<List<Pressure>> = _pressureLiveData

    private val _temperatureLiveData = MutableLiveData<List<Temperature>>(listOf())
    val temperatureLiveData: LiveData<List<Temperature>> = _temperatureLiveData

    private val _sleepLiveData = MutableLiveData<List<Sleep>>(listOf())
    val sleepLiveData: LiveData<List<Sleep>> = _sleepLiveData

    fun getData() {
        if (token != null && currentUserService.currentUser.value != null && currentUserService.currentUser.value!!.id != null) {
            viewModelScope.launch {
                val pulse = getConstantsService.getPulse(token, currentUserService.currentUser.value!!.id!!)
                val pressure = getConstantsService.getPressure(token, currentUserService.currentUser.value!!.id!!)
                val temperature = getConstantsService.getTemperature(token, currentUserService.currentUser.value!!.id!!)
                val sleep = getConstantsService.getSleep(token, currentUserService.currentUser.value!!.id!!)

                if (pulse is LifelineResult.Success) {
                    Timber.i("Pulse loaded: size=${pulse.data.size}, data:\n ${pulse.data}")
                    _pulseLiveData.postValue(pulse.data!!)
                } else if (pulse is LifelineResult.Error) {
                    Timber.e("Exception at pulse response: ${pulse.exception.message}")
                    //FIXME show an error to user
                }

                if (pressure is LifelineResult.Success) {
                    Timber.i("Pressure loaded: ${pressure.data.size}")
                    _pressureLiveData.postValue(pressure.data!!)
                } else if (pressure is LifelineResult.Error) {
                    Timber.e("Exception at pressure response: ${pressure.exception.message}")
                    //FIXME show an error to user
                }

                if (temperature is LifelineResult.Success) {
                    Timber.i("Temperature loaded: ${temperature.data.size}")
                    _temperatureLiveData.postValue(temperature.data!!)
                } else if (temperature is LifelineResult.Error) {
                    Timber.e("Exception at temperature response: ${temperature.exception.message}")
                    //FIXME show an error to user
                }

                if (sleep is LifelineResult.Success) {
                    Timber.i("Sleep loaded: ${sleep.data.size}")
                    _sleepLiveData.postValue(sleep.data!!)
                } else if (sleep is LifelineResult.Error) {
                    Timber.e("Exception at sleep response: ${sleep.exception.message}")
                    //FIXME show an error to user
                }
            }
        }
    }

    fun setupChart(chart: LineChart, chartData: ChartData) {
        chartService.setupChart(chart, chartData)
    }


    //TEST ONLY
    fun mockData() {
        createPressureData()
        createPulseData()
        createTemperatureData()
        createSleepData()
    }

    private fun createPressureData() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -51)
        val pressureList = mutableListOf<Pressure>()
        for (i in 0..50) {
            pressureList.add(
                Pressure(
                    currentUserService.currentUser.value!!.id!!,
                    DateFormatter.format(calendar),
                    rand(100, 160),
                    rand(60, 100),
                )
            )
            calendar.add(Calendar.DATE, 1)
        }
        _pressureLiveData.postValue(pressureList)
    }

    private fun createPulseData() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -51)
        val pulseList = mutableListOf<Pulse>()
        for (i in 0..50) {
            pulseList.add(
                Pulse(
                    currentUserService.currentUser.value!!.id!!,
                    DateFormatter.format(calendar),
                    rand(40, 160)
                )
            )
            calendar.add(Calendar.DATE, 1)
        }
        _pulseLiveData.postValue(pulseList)
    }

    private fun createTemperatureData(){
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -51)
        val temperatureList = mutableListOf<Temperature>()
        for (i in 0..50) {
            temperatureList.add(
                Temperature(
                    currentUserService.currentUser.value!!.id!!,
                    DateFormatter.format(calendar),
                    rand(35.0, 39.9)
                )
            )
            calendar.add(Calendar.DATE, 1)
        }
        _temperatureLiveData.postValue(temperatureList)
    }

    private fun createSleepData(){
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -51)
        val sleepList = mutableListOf<Sleep>()
        for (i in 0..50) {
            sleepList.add(
                Sleep(
                    currentUserService.currentUser.value!!.id!!,
                    DateFormatter.format(calendar),
                    randSleep()
                )
            )
            calendar.add(Calendar.DATE, 1)
        }
        _sleepLiveData.postValue(sleepList)
    }

    private fun rand(start: Int, end: Int): Int {
        return (Math.random() * (end - start + 1)).toInt() + start
    }

    private fun rand(start: Double, end: Double): Double {
        return (Math.random() * (end - start + 1)) + start
    }

    private fun randSleep(): String{
        val hours = rand(1, 10)
        val minutes = rand(0, 59)
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR, hours)
        calendar.set(Calendar.MINUTE, minutes)

        return DateFormatter.format(calendar)
    }
}