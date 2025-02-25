package com.artemissoftware.amphitritetheater2.clippedcircle.composables

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import com.artemissoftware.amphitritetheater2.clippedcircle.models.ClipDirection

class ClippedCircleShape(val clipDirection: ClipDirection = ClipDirection.START) : Shape {

    private companion object {
        const val DELTA_SPACE = .15F
    }

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val roundRectPath = Path().apply {
            addRoundRect(roundRect = getRoundRect(rect = size.toRect()))
        }

        val arcPath = Path().apply {
            val offset = when (clipDirection) {
                ClipDirection.START -> Offset(
                    x = -size.width + (size.width * DELTA_SPACE),
                    y = Offset.Zero.y
                )

                ClipDirection.END -> Offset(
                    x = size.width - (size.width * DELTA_SPACE),
                    y = Offset.Zero.y
                )

                ClipDirection.TOP -> Offset(
                    x = Offset.Zero.x,
                    y = -size.width + (size.height * DELTA_SPACE)
                )

                ClipDirection.BOTTOM -> Offset(
                    x = Offset.Zero.x,
                    y = size.width - (size.height * DELTA_SPACE)
                )
            }
            val clipRect = Rect(
                offset = offset,
                size = Size(
                    width = Offset.Zero.x + size.width,
                    height = Offset.Zero.y + size.height
                )
            )
            addRoundRect(roundRect = getRoundRect(rect = clipRect))
        }

        return Outline.Generic(
            Path.combine(
                operation = PathOperation.Difference,
                path1 = roundRectPath,
                path2 = arcPath
            )
        )
    }

    private fun getRoundRect(rect: Rect) =
        RoundRect(rect = rect, radiusX = rect.height / 2f, radiusY = rect.height / 2f)
}