package com.artemissoftware.amphitritetheater2.chart.composables

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme
import kotlin.math.round

@Composable
internal fun YScaleLines(
    barData: List<Int>,
    modifier: Modifier = Modifier,
) {
    val density = LocalDensity.current
    val textPaint = remember(density) {
        Paint().apply {
            color = Color.Black.hashCode()
            textAlign = Paint.Align.CENTER
            textSize = density.run { 12.sp.toPx() }
        }
    }

    // for y coordinates of y-axis scale to create horizontal dotted line indicating y-axis scale
    val yCoordinates = mutableListOf<Float>()

    val yAxisScaleSpacing by remember { mutableFloatStateOf(100f) }

    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)

    // y-axis scale and horizontal dotted lines on graph indicating y-axis scale
    Column(
        modifier = modifier,
        horizontalAlignment = CenterHorizontally
    ) {

        Canvas(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .fillMaxSize()
        ) {

                val yAxisScaleText = (barData.max()) / 3f

                (0..3).forEach { i ->
                    val text = round(barData.min() + yAxisScaleText * i).toString()
                    yCoordinates.add(size.height - yAxisScaleSpacing - i * size.height / 3f)

                    drawContext.canvas.nativeCanvas.apply {
                        drawText(
                            text,
                            30f,
                            size.height - yAxisScaleSpacing - i * size.height / 3f,
                            textPaint
                        )
                    }
                }

                // horizontal dotted lines on graph indicating y-axis scale
                (1..3).forEach {
                    drawLine(
                        start = Offset(x = yAxisScaleSpacing + 30F, y = yCoordinates[it]),
                        end = Offset(x= size.width, y = yCoordinates[it]),
                        color = Color.Gray,
                        strokeWidth = 5f,
                        pathEffect = pathEffect
                    )
                }

        }

    }
}

@Preview(showBackground = true)
@Composable
private fun YScaleLinesPreview() {
    val dataList = mutableListOf(0, 30, 60, 90, 50, 70)
    AmphitriteTheater2Theme {
        YScaleLines(
            barData = dataList,
        )
    }
}