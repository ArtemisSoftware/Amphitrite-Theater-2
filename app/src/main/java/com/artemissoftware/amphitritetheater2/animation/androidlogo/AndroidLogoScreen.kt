package com.artemissoftware.amphitritetheater2.animation.androidlogo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme

@Composable
fun AndroidLogoScreen() {

    Box(modifier = Modifier.fillMaxSize()){
        AndroidLogo(
            modifier = Modifier
                .size(width = 150.dp, height = 150.dp)
                .align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AndroidLogoScreenPreview() {
    AmphitriteTheater2Theme {
        AndroidLogoScreen()
    }
}