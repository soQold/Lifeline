package com.example.lifeline.utils

import java.util.*

class StringTransformer {
    companion object {
        //FIXME rework this
        fun transformPulse(value: String): Int? {
            if (StringValidator.validatePulse(value))
                return value.toInt()
            return null
        }

        fun transformSleep(hoursValue: String, minutesValue: String): String? {
            if (StringValidator.validateHours(hoursValue) && StringValidator.validateMinutes(
                    minutesValue
                )
            ) {
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.HOUR, hoursValue.toInt())
                calendar.set(Calendar.MINUTE, minutesValue.toInt())
                return DateFormatter.format(calendar)
            }
            return null
        }

        fun transformTemperature(value: String): Double? {
            if (StringValidator.validateTemperature(value))
                return value.toDouble()
            return null
        }

        fun transformPressure(valueSys: String, valueDia: String): Pair<Int, Int>? {
            if (StringValidator.validatePressureSys(valueSys) && StringValidator.validatePressureDia(
                    valueDia
                )
            )
                return Pair(valueSys.toInt(), valueDia.toInt())
            return null
        }
    }
}