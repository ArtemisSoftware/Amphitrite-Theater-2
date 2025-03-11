package com.artemissoftware.amphitritetheater2.animation.androidlogo

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme
import com.artemissoftware.amphitritetheater2.ui.theme.Android

@Composable
internal fun AndroidLogo(
    modifier: Modifier = Modifier,
    eyeColor: Color = Color.White,
    antennaColor: Color = Android,
    contentColor: Color = Android,
) {
    val eyesOffset = remember { mutableFloatStateOf(0.0f) }

    Canvas(
        modifier = modifier
            .pointerInput(Unit){
                detectDragGestures(
                    onDrag = { change, dragAmount ->
                        change.consume()

                        eyesOffset.value += dragAmount.x * 0.12f
                    },
                    onDragEnd = {
                        eyesOffset.floatValue = 0f
                    }
                )
            }
    ){
        val heightDiferential = 0.5F//0F//0.25f
        val heightSquare = 0F / 2//0.25f
        val height = size.height

        drawArc(
            startAngle = -180f,
            sweepAngle = 180f,
            useCenter = true,
            color = contentColor,
            size = Size(size.minDimension, height),
            topLeft = Offset(0f, height * heightDiferential)
        )

        drawCircle(
            color = eyeColor,
            center = Offset(size.minDimension * 0.3f + eyesOffset.floatValue, height * (0.8f - heightSquare)),
            radius = size.minDimension * 0.04f
        )

        drawCircle(
            color = eyeColor,
            center = Offset(size.minDimension * 0.7f + eyesOffset.floatValue, height * (0.8f - heightSquare)),
            radius = size.minDimension * 0.04f
        )

        rotate(
            degrees = 340f,
            pivot = Offset(size.minDimension * 0.2f, size.minDimension * 0.4f)
        ){
            drawRoundRect(
                color = antennaColor,
                size = Size(size.minDimension * 0.035f, height * 0.25f),
                cornerRadius = CornerRadius(size.minDimension * 0.02f),
                topLeft = Offset(size.minDimension * 0.2f + (eyesOffset.floatValue * 0.3f), height * (0.4f - heightSquare))
            )
        }

        rotate(
            degrees = 20f,
            pivot = Offset(size.minDimension * 0.8f, size.minDimension * 0.4f)
        ){
            drawRoundRect(
                color = antennaColor,
                size = Size(size.minDimension * 0.035f, height * 0.25f),
                cornerRadius = CornerRadius(size.minDimension * 0.02f),
                topLeft = Offset(size.minDimension * 0.8f + (eyesOffset.floatValue * 0.3f), height * (0.4f - heightSquare))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AndroidLogoPreview() {
    AmphitriteTheater2Theme {
        AndroidLogo(
            antennaColor = Color.Red,
            modifier = Modifier
                .size(100.dp),
        )
    }
}