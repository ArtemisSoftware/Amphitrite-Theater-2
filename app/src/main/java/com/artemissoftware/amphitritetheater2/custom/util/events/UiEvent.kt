package com.artemissoftware.amphitritetheater2.custom.util.events

import com.artemissoftware.amphitritetheater2.custom.snackbar.CustomSnackbar

sealed class UiEvent {
    data class Snackbar(val value: CustomSnackbar) : UiEvent()
}