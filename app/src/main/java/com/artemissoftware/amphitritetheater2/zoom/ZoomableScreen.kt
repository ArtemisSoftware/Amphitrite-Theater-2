package com.artemissoftware.amphitritetheater2.zoom

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade

@Composable
fun ZoomableScreen() {

    Box(modifier = Modifier.fillMaxSize()){
        ZoomableContent(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            content = {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://i.pinimg.com/736x/19/50/2e/19502e77bc6673f29a9dc6ae2d77e641.jpg")
                        .crossfade(true)
                        .build(),
                    contentDescription = "Zoomable Image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize()
                )
            }
        )
    }
}