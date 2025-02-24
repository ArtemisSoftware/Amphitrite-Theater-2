package com.artemissoftware.amphitritetheater2.custom.error

data class ErrorState(
    val title: String,
    val onFinish: () -> Unit
)
