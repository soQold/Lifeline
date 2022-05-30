package com.example.lifeline.services

import android.graphics.Color
import com.example.lifeline.domain.entities.constants.*
import com.example.lifeline.entities.ChartData
import com.example.lifeline.utils.DateFormatter
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class ChartService {
    fun setupChart(chart: LineChart, chartData: ChartData) {
        val lineData =
            if (!chartData.values.isNullOrEmpty() && chartData.values.first() is Pressure) {
                LineData(setupLineDataSet(chartData, true), setupLineDataSet(chartData, false))
            } else {
                LineData(setupLineDataSet(chartData, false))
            }
        chart.data = lineData

        chart.setTouchEnabled(chartData.isTouchEnabled)
        chart.dragDecelerationFrictionCoef = chartData.scrollSpeed
        chart.isDragEnabled = chartData.isDragEnabled
        chart.isScaleXEnabled = chartData.isXScaleEnabled
        chart.isScaleYEnabled = chartData.isYScaleEnabled
        chart.setDrawGridBackground(chartData.isGridEnabled)
        chart.isHighlightPerDragEnabled =chartData.isHighlightPerDragEnabled
        chart.setPinchZoom(chartData.isPinchZoom)
        chart.setBackgroundColor(chartData.backgroundColor)
        chart.animateX(chartData.xAnimateSpeed)

        chart.xAxis.position = chartData.positionX
        chart.xAxis.textSize = chartData.textSizeX
        chart.xAxis.textColor = chartData.textColorX
        chart.xAxis.setDrawAxisLine(chartData.isDrawAxisLineX)
        chart.xAxis.setDrawGridLines(chartData.isGridEnabled)
        chart.xAxis.setCenterAxisLabels(chartData.isCenterAxisLabelsX)
        chart.xAxis.labelRotationAngle = chartData.labelRotationAngle
        chart.xAxis.valueFormatter = chartData.valueFormatterX
    }

    private fun setupLineDataSet(chartData: ChartData, isSystolicPressure: Boolean): LineDataSet {
        var color = Color.RED
        val title = if (chartData.values?.firstOrNull() is Pressure && !isSystolicPressure) {
            color = Color.BLUE
            chartData.secondLineTitle

        } else {
            chartData.lineTitle
        }

        val dataSet = LineDataSet(createConstantList(chartData.values, isSystolicPressure), title)
        dataSet.lineWidth = chartData.lineWidth
        dataSet.circleRadius = chartData.circleRadius
        dataSet.axisDependency = chartData.axisDependency
        dataSet.color = color
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