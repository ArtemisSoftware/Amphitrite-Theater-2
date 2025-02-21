package com.artemissoftware.amphitritetheater2.circlereveal.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.amphitritetheater2.circlereveal.models.Location
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme
import com.artemissoftware.amphitritetheater2.ui.theme.Grey10

@Composable
internal fun ImageHolder(
    location: Location,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ){

        Image(
            painter = painterResource(id = location.image),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier=Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter)
                .fillMaxHeight(.5f)
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = .7f)
                        )
                    )
                )
        )

        Column(
            modifier= Modifier
                .align(Alignment.BottomCenter)
                .padding(18.dp)
        ) {
            Text(
                text = location.title,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = location.description,
                fontSize = 16.sp,
                color = Grey10
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ImageHolderPreview() {
    AmphitriteTheater2Theme {
        ImageHolder(
            location = Location.locations.first(),
            modifier = Modifier
                .fillMaxSize()
        )
    }
}