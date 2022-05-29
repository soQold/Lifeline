package com.example.lifeline.utils

class StringTransformer {
    companion object{
        //FIXME rework this
        fun transformPulse(value: String): Int?{
            return value.toInt()
        }

        fun transformSleep(value: String): Int?{
            return value.toInt()
        }

        fun transformTemperature(value: String): Double?{
            return value.toDouble()
        }

        fun transformPressure(value: String):Pair<Int, Int>?{
            return Pair(60, 120)
        }
    }
}