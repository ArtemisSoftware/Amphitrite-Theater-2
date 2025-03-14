package com.artemissoftware.amphitritetheater2.chart.bar.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme

@Composable
internal fun XAxisLine(
    xAxisScaleHeight: Dp,
    horizontalLineHeight: Dp,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {

        Box(
            modifier = Modifier
                .padding(bottom = xAxisScaleHeight)
                .clip(RoundedCornerShape(2.dp))
                .fillMaxWidth()
                .height(horizontalLineHeight)
                .background(Color.Gray)
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun XAxisLinesPreview() {
    AmphitriteTheater2Theme {
        XAxisLine(
            modifier = Modifier
                .fillMaxWidth(),
            xAxisScaleHeight = 42.dp,
            horizontalLineHeight = 42.dp,
        )
    }
}