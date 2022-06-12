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
        chart.description.isEnabled = chartData.isDescriptionEnabled
        chart.description.text = chartData.desrcriptionText

        chart.xAxis.position = chartData.positionX
        chart.xAxis.textSize = chartData.textSizeX
        chart.xAxis.textColor = chartData.textColorX
        chart.xAxis.setDrawAxisLine(chartData.isDrawAxisLineX)
        chart.xAxis.setDrawGridLines(chartData.isDrawGridLinesX)
        chart.xAxis.setCenterAxisLabels(chartData.isCenterAxisLabelsX)
        chart.xAxis.labelRotationAngle = chartData.labelRotationAngleX
        chart.xAxis.valueFormatter = chartData.valueFormatterX

        chart.axisLeft.setPosition(chartData.positionY)
        chart.axisLeft.textSize = chartData.textSizeY
        chart.axisLeft.textColor = chartData.textColorY
        chart.axisLeft.setDrawGridLines(chartData.isDrawAxisLineY)
        chart.axisLeft.setDrawGridLines(chartData.isDrawGridLinesY)
        chart.axisLeft.setCenterAxisLabels(chartData.isCenterAxisLabelsY)
        chart.axisLeft.valueFormatter = chartData.valueFormatterY
        chart.axisRight.setPosition(chartData.positionY)
        chart.axisRight.textSize = chartData.textSizeY
        chart.axisRight.textColor = chartData.textColorY
        chart.axisRight.setDrawGridLines(chartData.isDrawAxisLineY)
        chart.axisRight.setDrawGridLines(chartData.isDrawGridLinesY)
        chart.axisRight.setCenterAxisLabels(chartData.isCenterAxisLabelsY)
        chart.axisRight.valueFormatter = chartData.valueFormatterY
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
                    result.add(Entry(convertDateToFloat(value.date), convertSleepToFloat(value.value)))
                }
            }
        }
        return result
    }

    private fun convertDateToFloat(value: String) =
        DateFormatter.parse(value).timeInMillis.toFloat()

    private fun convertSleepToFloat(value: String) = DateFormatter.parseSleep(value).timeInMillis.toFloat()
}