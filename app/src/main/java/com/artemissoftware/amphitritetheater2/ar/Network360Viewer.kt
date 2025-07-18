@file:OptIn(ExperimentalCoilApi::class)

package com.artemissoftware.amphitritetheater2.ar

import android.content.Context
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.AsyncImage
import coil3.imageLoader
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.allowHardware
import coil3.request.crossfade

@Composable
fun Network360Viewer(
    modifier: Modifier = Modifier,
    frameCount: Int = 18,
    baseUrl: String = "https://raw.githubusercontent.com/rameshvoltella/360-Productview-Android-App/refs/heads/master/app/src/main/assets/images/image1_",
    extension: String = ".jpg"
) {
    var currentFrame by remember { mutableIntStateOf(1) }
    var previousDragX by remember { mutableStateOf<Float?>(null) }

    val imageUrl = remember(currentFrame) {
        "$baseUrl$currentFrame$extension"
    }

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
                    detectHorizontalDragGestures { change, dragAmount ->
                        if (dragAmount > 5) {
                            currentFrame = (currentFrame - 1 + frameCount) % frameCount
                        } else if (dragAmount < -5) {
                            currentFrame = (currentFrame + 1) % frameCount
                        }

                        if(currentFrame == 0) currentFrame = 18

                        previousDragX = change.position.x
                    }

                }
        )

        Text("CurrentFrame: $currentFrame")

    }
}

@Composable
fun Network360ViewerSlowerSpin(
    modifier: Modifier = Modifier,
    frameCount: Int = 18,
    baseUrl: String = "https://raw.githubusercontent.com/rameshvoltella/360-Productview-Android-App/refs/heads/master/app/src/main/assets/images/image1_",
    extension: String = ".jpg"
) {
    var currentFrame by remember { mutableIntStateOf(1) }

    val imageUrl = remember(currentFrame) {
        "$baseUrl$currentFrame$extension"
    }

    val dragThreshold = 30f
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
