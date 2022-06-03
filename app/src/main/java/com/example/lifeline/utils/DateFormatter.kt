package com.example.lifeline.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class DateFormatter {
    companion object {
        @SuppressLint("SimpleDateFormat")
        private val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")

        @SuppressLint("SimpleDateFormat")
        private val sleepFormatter = SimpleDateFormat("HH:mm")

        private val dateOnlyFormatter = SimpleDateFormat("dd/MM/yy")

        fun format(value: Calendar): String {
            return formatter.format(value.time)
        }

        fun formatDateOnly(value: Calendar): String {
            return dateOnlyFormatter.format(value.time)
        }

        fun formatSleep(value: Calendar): String {
            return sleepFormatter.format(value.time)
        }

        fun parse(value: String): Calendar {
            val calendar = Calendar.getInstance()
            val formatted = formatter.parse(value)
            if(formatted != null)
                calendar.time = formatted
            return calendar
        }

        fun parseSleep(value: String): Calendar {
            val calendar = Calendar.getInstance()
            val formatted = formatter.parse(value)
            if(formatted != null) {
                calendar.set(Calendar.HOUR, formatted.hours)
                calendar.set(Calendar.MINUTE, formatted.minutes)
            }
            return calendar
        }

        fun parseDateOnly(value: String): Calendar {
            val calendar = Calendar.getInstance()
            val formatted = dateOnlyFormatter.parse(value)
            if(formatted != null) {
                calendar.time = formatted
            }
            return calendar
        }
    }
}