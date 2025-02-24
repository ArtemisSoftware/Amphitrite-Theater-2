package com.artemissoftware.amphitritetheater2.custom

sealed interface CustomScaffoldEvent {
    data object ChangeImage: CustomScaffoldEvent
}