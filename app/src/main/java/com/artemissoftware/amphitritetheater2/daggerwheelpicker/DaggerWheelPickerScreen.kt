package com.artemissoftware.amphitritetheater2.daggerwheelpicker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitritetheater2.daggerwheelpicker.composables.WheelPicker
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme

@Composable
fun DaggerWheelPickerScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val lists = arrayListOf<Int>().apply {
            repeat(50) {
                add(it)
            }
        }

        WheelPicker(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow.copy(alpha = 0.5f))
                .padding(20.dp),
            pickerMaxHeight = 250.dp,
            defaultTextStyle = MaterialTheme.typography.bodyMedium,
            centerTextStyle = MaterialTheme.typography.bodyLarge,
            lists = lists
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DaggerWheelPickerScreenPreview() {
    AmphitriteTheater2Theme {
        DaggerWheelPickerScreen()
    }
}