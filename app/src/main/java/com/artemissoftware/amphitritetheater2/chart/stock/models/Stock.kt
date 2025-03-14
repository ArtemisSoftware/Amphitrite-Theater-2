package com.artemissoftware.amphitritetheater2.chart.stock.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Stock(
    val company: String,
    @DrawableRes val icon: Int,
    val color: Color,
    val price: Double,
    val date: Long
)
