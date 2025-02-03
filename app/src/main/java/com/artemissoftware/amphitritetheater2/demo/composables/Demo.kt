package com.artemissoftware.amphitritetheater2.demo.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.amphitritetheater2.demo.navigation.Route

@Composable
fun Demo(
    onClick: () -> Unit,
    title: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
                .clickable {
                    onClick()
                }
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth(),
            )
        }

        HorizontalDivider(
            modifier = Modifier
                .padding(horizontal = 12.dp),
            thickness = 1.dp,
            color = Color.LightGray,
        )
    }
}