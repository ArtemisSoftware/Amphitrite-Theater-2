package com.artemissoftware.amphitritetheater2.imagecaching

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.SubcomposeAsyncImage
import coil3.imageLoader
import coil3.memory.MemoryCache
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.artemissoftware.amphitritetheater2.R
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme

@Composable
fun ImageCachingScreen() {

    val imageLoader = LocalContext.current.imageLoader
    val imageUrl = "https://static.wikia.nocookie.net/saintseiya/images/6/65/Marina-Sorento-anime.jpg"
    val imageUrl2 = "https://ovicio.com.br/wp-content/uploads/2024/06/20240616-kasa-saintseiya.jpeg"

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        SubcomposeAsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1280f / 847f)
        )

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl2)
                .crossfade(true)
                .listener(
                    onStart = { println("Coil: Image loading started") },
                    onSuccess = { _, _ -> println("Coil: Image loaded successfully") },
                    onError = { _, throwable -> println("Coil: Image failed - ${throwable.throwable.message}") }
                )
                .build(),
            placeholder = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1280f / 692f),
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                // Remove all images
                //imageLoader.diskCache?.clear()
                //imageLoader.memoryCache?.clear()

                // Remove specific image
                imageLoader.diskCache?.remove(imageUrl)
                imageLoader.memoryCache?.remove(MemoryCache.Key(imageUrl))
            },
            content = {
                Text(stringResource(R.string.clear_cache))
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ImageCachingScreenPreview() {
    AmphitriteTheater2Theme {
        ImageCachingScreen()
    }
}