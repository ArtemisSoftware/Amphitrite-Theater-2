package com.artemissoftware.amphitritetheater2.chart.bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitritetheater2.chart.bar.BarType.Companion.getShape
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme

@Composable
fun BarGraphScreen() {
    Column(
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val dataList = mutableListOf(30,60,90,50,70)
        val floatValue = mutableListOf<Float>()
        val datesList = mutableListOf(2,3,4,5,6)

        dataList.forEachIndexed { index, value ->

            floatValue.add(index = index, element = value.toFloat()/dataList.max().toFloat())

        }
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

@Preview(showBackground = true)
@Composable
private fun BarGraphScreenPreview() {
    AmphitriteTheater2Theme {
        BarGraphScreen()
    }
}
