package com.artemissoftware.amphitritetheater2.paymentcard

import androidx.annotation.DrawableRes
import com.artemissoftware.amphitritetheater2.R

internal enum class CardType(
    val title: String,
    @DrawableRes val image: Int,
) {
    None("", R.drawable.ic_visa_logo),
    Visa("visa", R.drawable.ic_visa_logo),
}