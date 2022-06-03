package com.example.lifeline.utils

import androidx.core.text.isDigitsOnly
import java.lang.Exception

//FIXME make validations
class StringValidator {
    companion object {
        fun validateUsernameOrEmail(value: String): Boolean {
            return true
        }

        fun validateUsername(value: String): Boolean {
            return true
        }

        fun validateEmail(value: String): Boolean {
            return true
        }

        fun validatePassword(value: String): Boolean {
            return true
        }

        fun validatePolicy(value: String): Boolean {
            return true
        }

        fun validateHeight(value: String): Boolean {
            return true
        }

        fun validateWeight(value: String): Boolean {
            return true
        }

        fun validateBirthDate(value: String): Boolean {
            return true
        }

        fun validatePressureSys(value: String): Boolean {
            if (value.isNotEmpty() && value.isDigitsOnly() && value.toInt() > ConstantVariables.minPressureSys && value.toInt() < ConstantVariables.maxPressureSys)
                return true
            return false
        }

        fun validatePressureDia(value: String): Boolean {
            if (value.isNotEmpty() && value.isDigitsOnly() && value.toInt() > ConstantVariables.minPressureDia && value.toInt() < ConstantVariables.maxPressureDia)
                return true
            return false
        }

        fun validatePulse(value: String): Boolean {
            if (value.isNotEmpty() && value.isDigitsOnly() && value.toInt() > ConstantVariables.minPulse && value.toInt() < ConstantVariables.maxPulse)
                return true
            return false
        }

        fun validateTemperature(value: String): Boolean{
            if(value.isNotEmpty()){
                try {
                    if(value.toDouble() > ConstantVariables.minTemperature && value.toDouble() < ConstantVariables.maxTemperature)
                        return true
                }
                catch (e: Exception){
                    return false
                }
            }
            return false
        }

        fun validateHours(value: String): Boolean{
            if(value.isNotEmpty() && value.toInt() >= ConstantVariables.minHours && value.toInt() < ConstantVariables.maxHours)
                return true
            return false
        }

        fun validateMinutes(value: String): Boolean{
            if(value.isNotEmpty() && value.toInt() >= ConstantVariables.minMinutes && value.toInt() < ConstantVariables.maxMinutes)
                return true
            return false
        }
    }
}