package com.artemissoftware.amphitritetheater2.chart.stock.util

import android.content.Context
import androidx.compose.ui.geometry.Offset
import com.artemissoftware.amphitritetheater2.R
import com.artemissoftware.amphitritetheater2.chart.stock.models.Stock
import com.artemissoftware.amphitritetheater2.ui.theme.BLUE200
import com.artemissoftware.amphitritetheater2.ui.theme.PINK200
import com.artemissoftware.amphitritetheater2.ui.theme.RED600
import org.json.JSONArray

internal object StockConstants {

    val MONTHS = listOf(
        "Jan",
        "Feb",
        "Mar",
        "Apr",
        "May",
        "Jun",
        "Jul",
        "Aug",
        "Sep",
        "Oct",
        "Nov",
        "Dec"
    )

    val STOCKS =  listOf(
        Stock(
            company = "Dribbble",
            icon = R.drawable.ic_dribbble_logo,
            color = PINK200,
            price = 66.43,
            date = System.currentTimeMillis()
        ),
        Stock(
            company = "Skype",
            icon = R.drawable.ic_skype_logo,
            color = BLUE200,
            price = -32.60,
            date = System.currentTimeMillis()
        ),
        Stock(
            company = "Youtube Premium",
            icon = R.drawable.ic_youtube_logo,
            color = RED600,
            price = -12.00,
            date = System.currentTimeMillis()
        )
    )

    fun getPoints(context: Context): List<Offset> {
        val json = context.assets.open("coordinator.json").bufferedReader().use { it.readLine() }
        val array = JSONArray(json)
        val points = mutableListOf<Offset>()

        for (i in 0 until array.length()) {
            val coordinate = array.optJSONArray(i)
            val x = coordinate.optDouble(0).toFloat()
            val y = coordinate.optDouble(1).toFloat()
            points += Offset(x, y)
        }

        return points
    }
}