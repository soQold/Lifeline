package com.example.lifeline.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class DateFormatter {
    companion object {
        @SuppressLint("SimpleDateFormat")
        private val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")

        fun format(value: Calendar): String {
            return formatter.format(value.time)
        }

        fun parse(value: String): Calendar {
            val calendar = Calendar.getInstance()
            val formatted = formatter.parse(value)
            if(formatted != null)
                calendar.time = formatted
            return calendar
        }
    }
}