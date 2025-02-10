package com.artemissoftware.amphitritetheater2.bouncingball

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitritetheater2.R
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme

@Composable
fun BouncingBallScreen() {
    var animateMove by remember { mutableStateOf(false) }

    val move = animateDpAsState(
        targetValue = if (animateMove) 200.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy
        ),
        label = ""
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .offset { IntOffset(x = move.value.roundToPx(), y = 0)  }
                .clip(CircleShape)
                .background(Color.Red)
                .align(Alignment.Start)
        )
        Spacer(Modifier.height(100.dp))
        Button(
            onClick = { animateMove = !animateMove },
            content = {
                Text(stringResource(R.string.move))
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BouncingBallScreenPreview() {
    AmphitriteTheater2Theme {
        BouncingBallScreen()
    }
}