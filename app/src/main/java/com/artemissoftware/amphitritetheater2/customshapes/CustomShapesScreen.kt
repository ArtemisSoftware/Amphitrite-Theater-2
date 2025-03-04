package com.artemissoftware.amphitritetheater2.customshapes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.amphitritetheater2.customshapes.shape.SpeechBubbleShape
import com.artemissoftware.amphitritetheater2.customshapes.shape.TicketShape
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme

@Composable
fun CustomShapesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "Bubble shape",
        )

        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(SpeechBubbleShape())
                .background(Color.Red)
        ) {
            Text(
                text = "Hello world!",
                modifier = Modifier
                    .offset(x = 20.dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clip(SpeechBubbleShape())
                .background(Color.Green)
        ) {
            Text(
                text = "Hello world!",
                modifier = Modifier
                .offset(x = 32.dp, y = 16.dp)
            )
        }

        Text(
            text = "Ticket",
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clip(TicketShape(24.dp))
                .background(Color.Green)
        ) {
            Text(
                text = "🎉 CINEMA TICKET 🎉",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.Center)
                    .background(Color.Cyan)
            )
        }

        Text(
            text = "🎉 CINEMA TICKET 🎉",
            style = TextStyle(
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Black,
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .wrapContentSize()
                .graphicsLayer {
                    shadowElevation = 8.dp.toPx()
                    shape = TicketShape(24.dp)
                    clip = true
                }
                .background(color = Color.Magenta)
                .drawBehind {
                    scale(scale = 0.9f) {
                        drawPath(
                            path = TicketShape.drawTicketPath(size = size, cornerRadius = 24.dp.toPx()),
                            color = Color.Black,
                            style = Stroke(
                                width = 2.dp.toPx(),
                                pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f))
                            )
                        )
                    }
                }
                .padding(horizontal = 32.dp)
                .padding(vertical = 64.dp)
                //.padding(start = 32.dp, top = 64.dp, end = 32.dp, bottom = 64.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CustomShapesScreenPreview() {
    AmphitriteTheater2Theme {
        CustomShapesScreen()
    }
}