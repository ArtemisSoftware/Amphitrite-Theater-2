package com.artemissoftware.amphitritetheater2.clippedcircle

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitritetheater2.R
import com.artemissoftware.amphitritetheater2.clippedcircle.composables.ClippedCircleShape
import com.artemissoftware.amphitritetheater2.clippedcircle.composables.ItemsWithMoreNumberOfItems
import com.artemissoftware.amphitritetheater2.clippedcircle.composables.RowItem
import com.artemissoftware.amphitritetheater2.clippedcircle.models.ClipDirection
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme

@Composable
fun ClippedCircleScreen() {

    val userItems: List<Int> = listOf(
        R.drawable.cdz_2,
        R.drawable.cdz_2,
        R.drawable.cdz_2,
        R.drawable.cdz_2,
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        item {
            RowItem(title = "Clipped Circle in a list") {
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    itemsIndexed(items = userItems) { index: Int, item: Int ->
                        Image(
                            painter = painterResource(id = item),
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                                .clip(
                                    if (index == 0) {
                                        CircleShape
                                    } else {
                                        ClippedCircleShape(clipDirection = ClipDirection.START)
                                    }
                                )
                        )
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(32.dp))
        }

        item {
            RowItem(title = "Clipped Circle in a list") {
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    itemsIndexed(items = userItems) { index: Int, item: Int ->
                        Image(
                            painter = painterResource(id = item),
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                                .clip(
                                    if (index == (userItems.size - 1)) {
                                        CircleShape
                                    } else {
                                        ClippedCircleShape(clipDirection = ClipDirection.END)
                                    }
                                )
                        )
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(32.dp))
        }

        item {
            ItemsWithMoreNumberOfItems()
        }

    }
}


@Preview(showBackground = true)
@Composable
private fun ClippedCircleScreenPreview() {
    AmphitriteTheater2Theme {
        ClippedCircleScreen()
    }
}