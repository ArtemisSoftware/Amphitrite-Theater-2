package com.artemissoftware.amphitritetheater2.chart.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme

@Composable
internal fun Bar(
    height: Dp,
    barWidth: Dp,
    barColor: Color,
    graphBarHeight: Float,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
//            .clip(barShap)
            .width(barWidth)
            .height(height/* - 10.dp*/)
//            .background(Color.Transparent)
        ,
        contentAlignment = BottomCenter
    ) {
        Box(
            modifier = Modifier
//                .clip(barShap)
                .fillMaxWidth()
                .fillMaxHeight(graphBarHeight)
                .background(barColor)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BarPreview() {
    AmphitriteTheater2Theme {
        Bar(
            modifier = Modifier
                .fillMaxWidth(),
            height = 200.dp,
            barWidth = 10.dp,
            graphBarHeight = 0.5F,
            barColor = Color.Red
        )
    }
}