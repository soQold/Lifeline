package com.example.lifeline.entities

import android.graphics.Color
import com.example.lifeline.domain.entities.constants.BioConstant
import com.example.lifeline.utils.ChartDateFormatter
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate

// pressureType:

data class ChartData(
    // Text info
    val title: String? = null,
    val lineTitle: String,
    val secondLineTitle: String? = null,
    val chartDescription: String? = null,

    // Chart settings
    val isTouchEnabled: Boolean = true,
    val scrollSpeed: Float = 0.9f,
    val isXScaleEnabled: Boolean = false,
    val isYScaleEnabled: Boolean = false,
    val isGridEnabled: Boolean = false,
    val isHighlightPerDragEnabled: Boolean = false,
    val isPinchZoom: Boolean = true,
    val backgroundColor: Int = Color.BLUE,
    val xAnimateSpeed: Int = 1500,

    // XAxis settings
    val positionX: XAxis.XAxisPosition = XAxis.XAxisPosition.BOTTOM,
    val textSizeX: Float = 10f,
    val textColorX: Int = Color.BLACK,
    val isDrawAxisLineX: Boolean = true,
    val isDrawGridLinesX: Boolean = true,
    val isCenterAxisLabelsX: Boolean = true,
    val valueFormatterX: ValueFormatter? = null,
    val labelRotationAngle: Float = 45f,

    // SetSettings
    val lineWidth: Float = 1f,
    val circleRadius: Float = 2f,
    val axisDependency: YAxis.AxisDependency = YAxis.AxisDependency.LEFT,
    val colorSet: Int = ColorTemplate.PASTEL_COLORS.first(),
    val textColorSet: Int = Color.BLUE,
    val textSizeSet: Float = 10f,

    // Data
    val values: List<BioConstant>? = null
){
}