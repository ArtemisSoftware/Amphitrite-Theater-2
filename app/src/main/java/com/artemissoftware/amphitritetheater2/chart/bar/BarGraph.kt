package com.artemissoftware.amphitritetheater2.chart.bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitritetheater2.chart.bar.BarType.Companion.getShape
import com.artemissoftware.amphitritetheater2.chart.bar.composables.FullBar
import com.artemissoftware.amphitritetheater2.chart.bar.composables.XAxisLine
import com.artemissoftware.amphitritetheater2.chart.bar.composables.YScaleLines
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme

@Composable
internal fun BarGraph(
    graphBarData: List<Float>,
    xAxisScaleData: List<Int>,
    barData_: List<Int>,
    height: Dp,
    barShape: Shape,
    barWidth: Dp,
    barColor: Color,
    barArrangement: Arrangement.Horizontal
) {

    val barData by remember {
        mutableStateOf(barData_+0)
    }

    // for getting screen width and height you can use LocalConfiguration
    val configuration = LocalConfiguration.current
    // getting screen width
    val width = configuration.screenWidthDp.dp

    // bottom height of the X-Axis Scale
    val xAxisScaleHeight = 40.dp

    val yAxisTextWidth by remember {
        mutableStateOf(100.dp)
    }

    val horizontalLineHeight = 5.dp

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopStart
    ) {

        YScaleLines(
            modifier = Modifier
                .padding(top = xAxisScaleHeight, end = 3.dp)
                .height(height)
                .fillMaxWidth(),
            barData = barData,
        )

        Box(
            modifier = Modifier
                .padding(start = 50.dp)
                .width(width - yAxisTextWidth)
                .height(height + xAxisScaleHeight),
            contentAlignment = BottomCenter
        ) {

            Row(
                modifier = Modifier
                    .width(width - yAxisTextWidth),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = barArrangement
            ) {
                graphBarData.forEachIndexed { index, value ->

                    FullBar(
                        modifier = Modifier
                                .fillMaxHeight(),
                        height = height - 10.dp,
                        barWidth = barWidth,
                        barHeight = value,
                        barColor = barColor,
                        point = xAxisScaleData[index],
                        xAxisScaleHeight = xAxisScaleHeight,
                        horizontalLineHeight = horizontalLineHeight,
                        lineHeightXAxis = 12.dp,
                        barShape = barShape
                    )
                }

            }

            XAxisLine(
                modifier = Modifier
                    .fillMaxWidth(),
                xAxisScaleHeight = xAxisScaleHeight ,
                horizontalLineHeight = horizontalLineHeight
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BarGraphPreview() {
    val dataList = mutableListOf(30,60,90,50,70)
    val floatValue = mutableListOf<Float>()
    val datesList = mutableListOf(2,3,4,5,6)

    dataList.forEachIndexed { index, value ->

        floatValue.add(index = index, element = value.toFloat()/dataList.max().toFloat())

    }
    AmphitriteTheater2Theme {
        BarGraph(
            graphBarData = floatValue,
            xAxisScaleData = datesList,
            barData_ = dataList,
            height = 300.dp,
            barShape = getShape(BarType.TOP_CURVED),
            barWidth = 20.dp,
            barColor = Color.Red,
            barArrangement = Arrangement.SpaceEvenly
        )
    }
}