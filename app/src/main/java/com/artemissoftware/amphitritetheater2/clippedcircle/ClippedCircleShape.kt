package com.artemissoftware.amphitritetheater2.clippedcircle

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitritetheater2.clippedcircle.composables.ClippedCircleShape
import com.artemissoftware.amphitritetheater2.clippedcircle.models.ClipDirection

private class ClipDirectionProvider : PreviewParameterProvider<ClipDirection> {
    override val values = ClipDirection.entries.asSequence()
}

@Preview
@Composable
private fun ClippedCircleShapePreview(
    @PreviewParameter(ClipDirectionProvider::class) clipDirection: ClipDirection
) {
    Box(
        Modifier
            .defaultMinSize(
                minWidth = 100.dp,
                minHeight = 100.dp
            )
            .background(
                color = Color.Gray,
                shape = ClippedCircleShape(clipDirection = clipDirection)
            )
            .clip(ClippedCircleShape(clipDirection = clipDirection))
            .padding(4.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "+9",
            maxLines = 1,
            color = Color.White,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Start,
        )
    }
}