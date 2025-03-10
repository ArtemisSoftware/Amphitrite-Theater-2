package com.artemissoftware.amphitritetheater2.chart.composables

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitritetheater2.chart.bar.BarType
import com.artemissoftware.amphitritetheater2.chart.bar.BarType.Companion.getShape
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme

@Composable
internal fun FullBar(
    height: Dp,
    barWidth: Dp,
    barColor: Color,
    barHeight: Float,
    barShape: Shape,
    point: Int,
    xAxisScaleHeight: Dp,
    horizontalLineHeight: Dp,
    lineHeightXAxis: Dp = 12.dp,
    modifier: Modifier = Modifier
) {

    var animationTriggered by remember { mutableStateOf(false) }

    val graphBarHeight by animateFloatAsState(
        targetValue = if (animationTriggered) barHeight else 0f,
        animationSpec = tween(
            durationMillis = 1000,
            delayMillis = 0
        )
    )

    LaunchedEffect(key1 = true) {
        animationTriggered = true
    }


    Column(
        modifier = modifier,
        verticalArrangement = Top,
        horizontalAlignment = CenterHorizontally
    ) {
        Bar(
            barColor = barColor,
            height = height,
            barWidth = barWidth,
            graphBarHeight = graphBarHeight,
            barShape = barShape,
            modifier = Modifier
                .padding(bottom = 5.dp)
        )

        XPointDisplay(
            point = point,
            horizontalLineHeight = horizontalLineHeight,
            lineHeightXAxis = lineHeightXAxis,
            modifier = Modifier
                .height(xAxisScaleHeight)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BarPreview() {
    AmphitriteTheater2Theme {
        FullBar(
            height = 200.dp,
            barWidth = 10.dp,
            barHeight = 0.5F,
            barColor = Color.Red,
            point = 2,
            xAxisScaleHeight = 42.dp,
            horizontalLineHeight = 42.dp,
            lineHeightXAxis = 12.dp,
            barShape = getShape(BarType.TOP_CURVED)
        )
    }
}