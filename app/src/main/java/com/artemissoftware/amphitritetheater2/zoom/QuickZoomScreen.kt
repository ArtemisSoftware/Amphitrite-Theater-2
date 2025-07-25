package com.artemissoftware.amphitritetheater2.zoom

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitritetheater2.R
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme

@Composable
fun QuickZoomScreen() {

    val list = listOf(
        R.drawable.cdz_1,
        R.drawable.cdz_2,
        R.drawable.cdz_3,
        R.drawable.cdz_4,
        R.drawable.cdz_5,
//        R.drawable.sofa_1,
//        R.drawable.sofa_2,
//        R.drawable.sofa_1,
//        R.drawable.sofa_2,
//        R.drawable.sofa_1,
//        R.drawable.sofa_2,
//        R.drawable.sofa_1,
//        R.drawable.sofa_2,
    )

    val pagerState = rememberPagerState(pageCount = { list.count() })
    var isZoomed by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        ZoomableContent(
            modifier = Modifier
                .fillMaxSize(),
            isContentZoomed = { zooming -> isZoomed = zooming },
            content = {
                HorizontalPager(
                    modifier = Modifier.fillMaxSize(),
                    state = pagerState,
                    userScrollEnabled = !isZoomed,
                ) { index ->
                    BannerItem(image = list.get(index = index))
                }
            }
        )

        Row(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(list.size) { index ->
                ProgressDot(selected = index == pagerState.currentPage)
            }
        }
    }
}

@Composable
private fun ProgressDot(selected: Boolean, modifier: Modifier = Modifier) {
    val transition = updateTransition(targetState = selected, label = "DotTransition")

    val dotColor by transition.animateColor(
        label = "DotColor"
    ) { isSelected ->
        if (isSelected) Color.Black else Color.Transparent
    }

    val borderColor by transition.animateColor(
        label = "BorderColor"
    ) { _ ->
        Color.Black
    }

    val borderWidth by transition.animateDp(
        label = "BorderWidth"
    ) { isSelected ->
        if (isSelected) 0.dp else 2.dp
    }

    Box(
        modifier = modifier
            .size(12.dp)
            .clip(CircleShape)
            .background(dotColor)
            .border(
                width = borderWidth,
                color = borderColor,
                shape = CircleShape
            )
    )
}

@Composable
private fun BannerItem(image: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = image),
            contentScale = ContentScale.Crop,
            contentDescription = "Banner Image"
        )
    }
}

@Preview
@Composable
private fun QuickZoomScreenPreview() {
    AmphitriteTheater2Theme {
        QuickZoomScreen()
    }
}