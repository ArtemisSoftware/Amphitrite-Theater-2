package com.artemissoftware.amphitritetheater2.ar

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import coil3.imageLoader
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.allowHardware

@Composable
fun PreloadAllFrames(
    frameCount: Int,
    baseUrl: String,
    extension: String,
    context: Context = LocalContext.current
) {
    LaunchedEffect(Unit) {
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

            context.imageLoader.execute(request)
        }
    }
}