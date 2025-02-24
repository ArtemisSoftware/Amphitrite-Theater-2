package com.artemissoftware.amphitritetheater2.custom

import com.artemissoftware.amphitritetheater2.R
import com.artemissoftware.amphitritetheater2.custom.error.ErrorState
import com.artemissoftware.amphitritetheater2.custom.snackbar.CustomSnackbar

data class CustomScaffoldState(
    val isLoading: Boolean = false,
    val errorState: ErrorState? = null,
    val image: Int = R.drawable.cdz_6
)
