@file:OptIn(ExperimentalComposeUiApi::class)

package com.artemissoftware.amphitritetheater2.circlereveal

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitritetheater2.circlereveal.composables.ImageHolder
import com.artemissoftware.amphitritetheater2.circlereveal.models.Location
import com.artemissoftware.amphitritetheater2.circlereveal.util.CirclePath
import com.artemissoftware.amphitritetheater2.circlereveal.util.extensions.endOffsetForPage
import com.artemissoftware.amphitritetheater2.circlereveal.util.extensions.offsetForPage
import com.artemissoftware.amphitritetheater2.circlereveal.util.extensions.startOffsetForPage
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme
import kotlin.math.absoluteValue


@Composable
fun CircleRevealScreen() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val state = rememberPagerState { Location.locations.size }

        val (offsetY,setOffsetY) = remember {
            mutableFloatStateOf(0f)
        }

        HorizontalPager(
            state = state,
            modifier= Modifier
                .pointerInteropFilter {
                    setOffsetY(it.y)
                    false
                }
                .padding(16.dp)
                .clip(RoundedCornerShape(14.dp))
        ) { page->
            ImageHolder(
                location = Location.locations[page],
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        val pageOffset = state.offsetForPage(page)
                        translationX = size.width * pageOffset

                        val endOffset = state.endOffsetForPage(page)
                        shadowElevation = 20f

                        shape = CirclePath(
                            progress = 1f - endOffset.absoluteValue,
                            origin = Offset(
                                size.width,
                                offsetY
                            )
                        )
                        clip = true

                        val abslouteOffset = state.offsetForPage(page).absoluteValue
                        val scale = 1f + (abslouteOffset.absoluteValue * .3f)

                        scaleX = scale
                        scaleY = scale

                        val startOffset = state.startOffsetForPage(page)
                        alpha = (2f - startOffset) / 2
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ListSwipeScreenPreview() {
    AmphitriteTheater2Theme {
        CircleRevealScreen()
    }
}