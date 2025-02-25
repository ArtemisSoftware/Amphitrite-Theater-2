package com.artemissoftware.amphitritetheater2.clippedcircle.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.amphitritetheater2.R
import com.artemissoftware.amphitritetheater2.clippedcircle.models.ClipDirection

@Composable
internal fun ItemsWithMoreNumberOfItems() {
    RowItem(title = "Clipped Circle in a list") {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.cdz_2),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(ClippedCircleShape(clipDirection = ClipDirection.END))
            )

            Image(
                painter = painterResource(id = R.drawable.cdz_2),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(ClippedCircleShape(clipDirection = ClipDirection.END))
            )

            Image(
                painter = painterResource(id = R.drawable.cdz_2),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(ClippedCircleShape(clipDirection = ClipDirection.END))
            )

            Image(
                painter = painterResource(id = R.drawable.cdz_2),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(ClippedCircleShape(clipDirection = ClipDirection.END))
            )

            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(
                        color = Color.Gray,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "+5", color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
        }
    }
}
