package com.example.lifeline.utils

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.ValueFormatter
import java.util.*

class ChartDateFormatter : ValueFormatter() {
    override fun getFormattedValue(value: Float): String {
        return "Date value"
    }

    override fun getAxisLabel(value: Float, axis: AxisBase): String {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = value.toLong()
        return DateFormatter.format(calendar)
    }
}