package com.artemissoftware.amphitritetheater2.custom.snackbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

sealed class CustomSnackbar(val message: String, val color: Color, val icon: ImageVector) {
    data class Success(val description: String) : CustomSnackbar(message = description, color = Color(0xFF388E3C), icon = Icons.Default.CheckCircle)
    data class Error(val description: String) : CustomSnackbar(message = description, color = Color(0xFFD32F2F), icon = Icons.Default.Warning)

    suspend fun showSnackbarEvent(snackbarHostState: SnackbarHostState) {
        val actionLabel = when (this) {
            is Error -> "Error"
            is Success -> "Success"
        }

        snackbarHostState.showSnackbar(
            message = message,
            actionLabel = actionLabel,
            duration = SnackbarDuration.Short
        )
    }
}