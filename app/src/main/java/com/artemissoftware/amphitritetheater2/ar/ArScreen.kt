package com.artemissoftware.amphitritetheater2.ar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.artemissoftware.amphitritetheater2.zoom.ZoomableContent

@Composable
fun ArScreen() {

    val frameCount = 18
    val baseUrl = "https://raw.githubusercontent.com/rameshvoltella/360-Productview-Android-App/refs/heads/master/app/src/main/assets/images/image1_"
    val extension = ".jpg"

    PreloadAllFrames(frameCount = frameCount, baseUrl = baseUrl, extension = extension)

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        ZoomableContent(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            content = {
                Network360Viewer(
                    frameCount = frameCount,
                    baseUrl = baseUrl,
                    extension = extension,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        )
    }
}