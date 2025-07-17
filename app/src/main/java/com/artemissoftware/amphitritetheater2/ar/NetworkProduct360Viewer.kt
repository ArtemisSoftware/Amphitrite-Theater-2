package com.artemissoftware.amphitritetheater2.ar

import android.content.Context
import androidx.compose.foundation.Image
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
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.allowHardware
import coil3.request.crossfade
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun NetworkProduct360Viewer(
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
fun NetworkProduct360ViewerSlowerSpin(
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

@Composable
fun Preload360Images(
    context: Context = LocalContext.current,
    frameCount: Int,
    baseUrl: String,
    extension: String
) {
    LaunchedEffect(Unit) {
        val imageLoader = ImageLoader(context)
        repeat(frameCount) { i ->
            val url = "$baseUrl${i + 1}$extension"
            val request = ImageRequest.Builder(context)
                .data(url)
                .build()
            imageLoader.enqueue(request)
        }
    }
}

@Composable
fun AggressivePreload360Images(
    context: Context = LocalContext.current,
    frameCount: Int,
    baseUrl: String,
    extension: String
) {
    LaunchedEffect(Unit) {
        val imageLoader = ImageLoader(context)
        withContext(Dispatchers.IO) {
            repeat(frameCount) { i ->
                val url = "$baseUrl${i + 1}$extension"
                val request = ImageRequest.Builder(context)
                    .data(url)
                    .memoryCacheKey(url)
                    .diskCacheKey(url)
                    .memoryCachePolicy(CachePolicy.ENABLED)
                    .diskCachePolicy(CachePolicy.ENABLED)
                    .allowHardware(false) // Ensure decode to bitmap
                    .build()

                // Force image to load and decode
                imageLoader.execute(request)
            }
        }
    }
}

@Composable
fun PreloadAllFrames(
    frameCount: Int,
    baseUrl: String,
    extension: String,
    context: Context = LocalContext.current
) {
    LaunchedEffect(Unit) {
        val imageLoader = ImageLoader(context)

        withContext(Dispatchers.IO) {
            repeat(frameCount) { index ->
                val url = "$baseUrl${index + 1}$extension"
                val request = ImageRequest.Builder(context)
                    .data(url)
                    .memoryCacheKey(url)
                    .diskCacheKey(url)
                    .memoryCachePolicy(CachePolicy.ENABLED)
                    .diskCachePolicy(CachePolicy.ENABLED)
                    .allowHardware(false)
                    .build()

                imageLoader.execute(request)
            }
        }
    }
}