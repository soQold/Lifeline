package com.example.lifeline.services

import com.example.lifeline.domain.entities.constants.*
import com.example.lifeline.entities.ChartData
import com.example.lifeline.utils.DateFormatter
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet

class ChartService {
    fun setupChart(chart: LineChart, chartData: ChartData) {

    }

    fun setupLineDataSet(chartData: ChartData, isSystolicPressure: Boolean): LineDataSet {
        val title = if(chartData.values?.firstOrNull() is Pressure && !isSystolicPressure){
            chartData.secondLineTitle
        } else {
            chartData.lineTitle
        }

        val dataSet = LineDataSet(createConstantList(chartData.values, isSystolicPressure), title)
        dataSet.lineWidth = chartData.lineWidth
        dataSet.circleRadius = chartData.circleRadius
        dataSet.axisDependency = chartData.axisDependency
        dataSet.color = chartData.colorSet

        return dataSet
    }

    private fun createConstantList(
        values: List<BioConstant>?,
        isSystolicPressure: Boolean
    ): List<Entry> {
        val result = mutableListOf<Entry>()
        if (values == null) {
            return result
        }
        for (value in values) {
            when (value) {
                is Pressure -> {
                    if (isSystolicPressure) {
                        result.add(
                            Entry(
                                convertDateToFloat(value.date),
                                value.valueSystolic.toFloat()
                            )
                        )
                    } else {
                        result.add(
                            Entry(
                                convertDateToFloat(value.date),
                                value.valueDiastolic.toFloat()
                            )
                        )
                    }
                }
                is Pulse -> {
                    result.add(Entry(convertDateToFloat(value.date), value.value.toFloat()))
                }
                is Temperature -> {
                    result.add(Entry(convertDateToFloat(value.date), value.value.toFloat()))
                }
                is Sleep -> {
                    result.add(Entry(convertDateToFloat(value.date), value.value.toFloat()))
                }
            }
        }
        return result
    }

    private fun convertDateToFloat(value: String) =
        DateFormatter.parse(value).timeInMillis.toFloat()
}