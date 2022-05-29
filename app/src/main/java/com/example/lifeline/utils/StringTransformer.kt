package com.example.lifeline.utils

class StringTransformer {
    companion object{
        //FIXME rework this
        fun transformPulse(value: String): Int?{
            if(StringValidator.validatePulse(value))
                return value.toInt()
            return null
        }

        fun transformSleep(value: String): Int?{
            return 8000
        }

        fun transformTemperature(value: String): Double?{
            return value.toDouble()
        }

        fun transformPressure(valueSys: String, valueDia: String):Pair<Int, Int>?{
            if(StringValidator.validatePressureSys(valueSys) && StringValidator.validatePressureDia(valueDia))
                return Pair(valueSys.toInt(), valueDia.toInt())
            return null
        }
    }
}