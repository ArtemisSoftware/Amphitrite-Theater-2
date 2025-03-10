package com.artemissoftware.amphitritetheater2.chart.bar

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

enum class BarType {
    CIRCULAR_TYPE,
    TOP_CURVED;

    companion object {

        fun getShape(barType: BarType) =
            when (barType) {
                CIRCULAR_TYPE -> CircleShape
                TOP_CURVED -> RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp)
            }
    }
}