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
import com.example.lifeline.services.GetConstantsService
import com.example.lifeline.services.TokenService
import com.github.mikephil.charting.charts.LineChart
import kotlinx.coroutines.launch
import timber.log.Timber

class StatisticsViewModel(private val getConstantsService: GetConstantsService, private val chartService: ChartService, tokenService: TokenService) : ViewModel() {
    private val token = tokenService.getAuthToken()
    private val _pulseLiveData = MutableLiveData<List<Pulse>>(listOf())
    val pulseLiveData: LiveData<List<Pulse>> = _pulseLiveData

    private val _pressureLiveData = MutableLiveData<List<Pressure>>(listOf())
    val pressureLiveData: LiveData<List<Pressure>> = _pressureLiveData

    private val _temperatureLiveData = MutableLiveData<List<Temperature>>(listOf())
    val temperatureLiveData: LiveData<List<Temperature>> = _temperatureLiveData

    private val _sleepLiveData = MutableLiveData<List<Sleep>>(listOf())
    val sleepLiveData: LiveData<List<Sleep>> = _sleepLiveData

    fun getData(){
        if(token != null)
        viewModelScope.launch {
            val pulse = getConstantsService.getPulse(token)
            val pressure = getConstantsService.getPressure(token)
            val temperature = getConstantsService.getTemperature(token)
            val sleep = getConstantsService.getSleep(token)

            if(pulse is LifelineResult.Success){
                Timber.i("Pulse loaded: ${pulse.data.size}")
                _pulseLiveData.postValue(pulse.data!!)
            }
            else if(pulse is LifelineResult.Error){
                Timber.e("Exception at pulse response: ${pulse.exception.message}")
                //FIXME show an error to user
            }

            if(pressure is LifelineResult.Success){
                Timber.i("Pressure loaded: ${pressure.data.size}")
                _pressureLiveData.postValue(pressure.data!!)
            }
            else if(pressure is LifelineResult.Error){
                Timber.e("Exception at pressure response: ${pressure.exception.message}")
                //FIXME show an error to user
            }

            if(temperature is LifelineResult.Success){
                Timber.i("Temperature loaded: ${temperature.data.size}")
                _temperatureLiveData.postValue(temperature.data!!)
            }
            else if(temperature is LifelineResult.Error){
                Timber.e("Exception at temperature response: ${temperature.exception.message}")
                //FIXME show an error to user
            }

            if(sleep is LifelineResult.Success){
                Timber.i("Sleep loaded: ${sleep.data.size}")
                _sleepLiveData.postValue(sleep.data!!)
            }
            else if(sleep is LifelineResult.Error){
                Timber.e("Exception at sleep response: ${sleep.exception.message}")
                //FIXME show an error to user
            }
        }
    }

    fun setupChart(chart: LineChart, chartData: ChartData){

    }
}