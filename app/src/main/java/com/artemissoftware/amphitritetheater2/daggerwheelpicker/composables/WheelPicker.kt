@file:OptIn(ExperimentalSnapperApi::class)

package com.artemissoftware.amphitritetheater2.daggerwheelpicker.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.LazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberLazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior
import kotlin.math.abs

@Composable
internal fun WheelPicker(
    modifier: Modifier,
    pickerMaxHeight: Dp = 250.dp,
    initIndex: Int? = null,
    lists: List<Int>,
    defaultTextStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    centerTextStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    defaultTextColor: Color = Color.Black.copy(alpha = 0.4f),
    centerTextColor: Color = Color.Black,
    selectedBackgroundColor: Color = Color.Black.copy(alpha = 0.3f)
) {
    val lazyListState = rememberLazyListState(
        initialFirstVisibleItemIndex = (Int.MAX_VALUE / 2.0).toInt() - 25
    )
    val layoutInfo: LazyListSnapperLayoutInfo = rememberLazyListSnapperLayoutInfo(lazyListState = lazyListState)
    var currentIndex: Int?

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(pickerMaxHeight),
            state = lazyListState,
            flingBehavior = rememberSnapperFlingBehavior(lazyListState),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(
                count = Int.MAX_VALUE,
                key = { it }
            ) {
                val index = it % lists.size

                currentIndex = layoutInfo.currentItem?.index?.minus(Int.MAX_VALUE / 2)?.plus(23)?.rem(lists.size)

                if (currentIndex != null && currentIndex!! < 0) {
                    currentIndex = currentIndex!! + lists.size
                }

                val curTextIsCenter = currentIndex == lists[index]
                val curTextIsCenterDiffer = currentIndex == abs(lists[index] - 1) ||
                        currentIndex == abs(lists[index] + 1)

                Text(
                    text = if (lists[index] == 0) "Index 0" else "Index ${lists[index]}",
                    style = if (curTextIsCenter) centerTextStyle else defaultTextStyle,
                    color = if (curTextIsCenter) centerTextColor else defaultTextColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(pickerMaxHeight * 0.215f)
                        .padding(vertical = 14.dp)
                        .align(Alignment.Center)
                        .scale(
                            scaleX = if (curTextIsCenter) 1.2f else if (curTextIsCenterDiffer) 1.0f else 0.8f,
                            scaleY = if (curTextIsCenter) 1.2f else if (curTextIsCenterDiffer) 1.0f else 0.8f
                        )
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(pickerMaxHeight * 0.215f)
                .background(selectedBackgroundColor)
        )

        LaunchedEffect(Unit) {
            initIndex?.let {
                lazyListState.scrollToItem(
                    index = (Int.MAX_VALUE / 2.0).toInt() - 25 + it,
                    scrollOffset = lazyListState.layoutInfo.visibleItemsInfo[0].size / 5
                )
            } ?: kotlin.run {
                lazyListState.scrollBy(
                    value = lazyListState.layoutInfo.visibleItemsInfo[0].size.toFloat() / 5
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WheelPickerPreview() {
    AmphitriteTheater2Theme {
        WheelPicker(
            lists = listOf(1,2,3,4,5),
            modifier = Modifier.fillMaxWidth()
        )
    }
}