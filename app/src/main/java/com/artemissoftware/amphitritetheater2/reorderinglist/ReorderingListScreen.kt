@file:OptIn(ExperimentalFoundationApi::class)

package com.artemissoftware.amphitritetheater2.reorderinglist

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitritetheater2.R
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme

@Composable
fun ReorderingListScreen() {

    var items by remember {
        mutableStateOf(
            listOf(
                "Apples", "Oranges", "BlueBerry",
                "Cranberry", "Strawberry", "grapes",
                "peaches", "lemons","watermelon",
                "papaya", "cherry", "avocado",
                "kiwi", "tangerine", "almond"
            )
        )
    }

    Column {
        LazyColumn(
            modifier = Modifier.weight(0.9F),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items = items, key = { it }){ item ->
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray.copy(alpha = 0.2f))
                        .padding(24.dp)
                        .animateItem(
                            placementSpec = tween(
                                durationMillis = 600
                            )
                        ),
                    text = stringResource(R.string.i_love, item),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(0.08F)
            .padding(12.dp)
        ){
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = { items = items.shuffled() },
                content = {
                    Text(stringResource(R.string.shuffle))
                }
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun ReorderingListScreenPreview() {
    AmphitriteTheater2Theme {
        ReorderingListScreen()
    }
}