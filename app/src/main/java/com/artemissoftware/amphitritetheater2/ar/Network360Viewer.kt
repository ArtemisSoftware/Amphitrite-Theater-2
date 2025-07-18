@file:OptIn(ExperimentalCoilApi::class)

package com.artemissoftware.amphitritetheater2.ar

import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade


@Composable
fun Network360Viewer(
    modifier: Modifier = Modifier,
    frameCount: Int = 18,
    dragThreshold: Float = 30f,
    baseUrl: String = "https://raw.githubusercontent.com/rameshvoltella/360-Productview-Android-App/refs/heads/master/app/src/main/assets/images/image1_",
    extension: String = ".jpg"
) {
    var currentFrame by remember { mutableIntStateOf(1) }

    val imageUrl = remember(currentFrame) {
        "$baseUrl$currentFrame$extension"
    }

    var accumulatedDrag by remember { mutableFloatStateOf(0f) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = "360° product view",
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxWidth()
                .pointerInput(Unit) {
                    detectHorizontalDragGestures { _, dragAmount ->
                        println("LOLO - detectHorizontalDragGestures")
                        accumulatedDrag += dragAmount

                        if (accumulatedDrag > dragThreshold) {
                            currentFrame = (currentFrame - 1 + frameCount) % frameCount
                            if (currentFrame == 0) currentFrame = frameCount
                            accumulatedDrag = 0f
                        } else if (accumulatedDrag < -dragThreshold) {
                            currentFrame = (currentFrame + 1) % frameCount
                            if (currentFrame == 0) currentFrame = frameCount
                            accumulatedDrag = 0f
                        }
                    }
                }
        )

        Text("CurrentFrame: $currentFrame")

    }
}
