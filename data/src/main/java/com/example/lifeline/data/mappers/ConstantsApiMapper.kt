package com.example.lifeline.data.mappers

import com.example.lifeline.data.api.NetworkModule
import com.example.lifeline.data.entities.response.constants.PressureResponse
import com.example.lifeline.data.entities.response.constants.PulseResponse
import com.example.lifeline.data.entities.response.constants.SleepResponse
import com.example.lifeline.data.entities.response.constants.TemperatureResponse
import com.example.lifeline.domain.entities.constants.Pressure
import com.example.lifeline.domain.entities.constants.Pulse
import com.example.lifeline.domain.entities.constants.Sleep
import com.example.lifeline.domain.entities.constants.Temperature

class ConstantsApiMapper{
    fun pressureRemoteToLocalList(response: List<PressureResponse>): List<Pressure>{
        val result = mutableListOf<Pressure>()
        for(item in response){
            result.add(
                Pressure(item.userId, item.date, item.valueSystolic, item.valueDiastolic)
            )
        }
        return result
    }

    fun pulseRemoteToLocalList(response: List<PulseResponse>): List<Pulse>{
        val result = mutableListOf<Pulse>()
        for(item in response){
            result.add(
                Pulse(item.userId, item.date, item.value)
            )
        }
        return result
    }

    fun temperatureRemoteToLocalList(response: List<TemperatureResponse>): List<Temperature>{
        val result = mutableListOf<Temperature>()
        for(item in response){
            result.add(
                Temperature(item.userId, item.date, item.value)
            )
        }
        return result
    }

    fun sleepRemoteToLocalList(response: List<SleepResponse>): List<Sleep>{
        val result = mutableListOf<Sleep>()
        for(item in response){
            result.add(
                Sleep(item.userId, item.date, item.value)
            )
        }
        return result
    }
}