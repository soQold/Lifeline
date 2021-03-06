package com.example.lifeline.entities

import android.graphics.Color
import com.example.lifeline.data.utils.DataConstants
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
    val lineTitle: String? = null,
    val secondLineTitle: String? = null,
    val chartDescription: String? = null,

    // Chart settings
    val isTouchEnabled: Boolean = true,
    val scrollSpeed: Float = 0.9f,
    val isDragEnabled: Boolean = true,
    val isXScaleEnabled: Boolean = false,
    val isYScaleEnabled: Boolean = false,
    val isGridEnabled: Boolean = false,
    val isHighlightPerDragEnabled: Boolean = false,
    val isPinchZoom: Boolean = true,
    val backgroundColor: Int = Color.WHITE,
    val xAnimateSpeed: Int = 1500,
    val isDescriptionEnabled:Boolean = false,
    val desrcriptionText: String = DataConstants.emptyString,

    // XAxis settings
    val positionX: XAxis.XAxisPosition = XAxis.XAxisPosition.BOTTOM,
    val textSizeX: Float = 10f,
    val textColorX: Int = Color.BLACK,
    val isDrawAxisLineX: Boolean = true,
    val isDrawGridLinesX: Boolean = true,
    val isCenterAxisLabelsX: Boolean = true,
    val valueFormatterX: ValueFormatter? = null,
    val labelRotationAngleX: Float = 45f,

    // YAxis settings
    val positionY: YAxis.YAxisLabelPosition = YAxis.YAxisLabelPosition.OUTSIDE_CHART,
    val textSizeY: Float = 10f,
    val textColorY: Int = Color.BLACK,
    val isDrawAxisLineY: Boolean = true,
    val isDrawGridLinesY: Boolean = true,
    val isCenterAxisLabelsY: Boolean = true,
    val valueFormatterY: ValueFormatter? = null,
    val labelRotationAngleY: Float = 45f,

    // SetSettings
    val lineWidth: Float = 1f,
    val circleRadius: Float = 2f,
    val axisDependency: YAxis.AxisDependency = YAxis.AxisDependency.LEFT,
    val colorSet: Int = ColorTemplate.PASTEL_COLORS.first(),
    val textColorSet: Int = Color.BLUE,
    val textSizeSet: Float = 12f,

    // Data
    val values: List<BioConstant>? = null
){
}