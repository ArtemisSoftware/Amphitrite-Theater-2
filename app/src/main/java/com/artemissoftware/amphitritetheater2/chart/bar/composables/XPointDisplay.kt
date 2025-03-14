package com.artemissoftware.amphitritetheater2.chart.bar.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme

@Composable
internal fun XPointDisplay(
    point: Int,
    horizontalLineHeight: Dp,
    lineHeightXAxis: Dp,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Top,
        horizontalAlignment = CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        bottomStart = 2.dp,
                        bottomEnd = 2.dp
                    )
                )
                .width(horizontalLineHeight)
                .height(lineHeightXAxis)
                .background(color = Color.Gray)
        )
        // scale x-axis
        Text(
            modifier = Modifier.padding(bottom = 3.dp),
            text = point.toString(),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            color = Color.Black
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun XAxisPreview() {
    AmphitriteTheater2Theme {
        XPointDisplay(
            modifier = Modifier
                .height(42.dp),
            point = 2,
            horizontalLineHeight = 42.dp,
            lineHeightXAxis = 12.dp,
        )
    }
}
