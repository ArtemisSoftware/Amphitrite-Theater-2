package com.artemissoftware.amphitritetheater2.demo.navigation

import kotlinx.serialization.Serializable

sealed class Route {

    @Serializable
    object Home

    @Serializable
    object PaymentCard

    @Serializable
    object ContextDropDownMenu

    @Serializable
    object ReorderingList

    @Serializable
    object ImageCaching
}

sealed class Destination(val title: String) {
    data object Home : Destination(title = "Demo")
    data object PaymentCard : Destination(title = "Payment Card")
    data object ContextDropDownMenu : Destination(title = "Context Drop Down Menu")
    data object ReorderingList : Destination(title = "Reordering List")
    data object ImageCaching : Destination(title = "Image Caching")

    companion object{

        fun getRoute(destination: Destination): Any {

            return when(destination){
                PaymentCard -> Route.PaymentCard
                ContextDropDownMenu -> Route.ContextDropDownMenu
                ReorderingList -> Route.ReorderingList
                ImageCaching -> Route.ImageCaching
                else -> Route.Home
            }
        }

        val demos = listOf(
            PaymentCard,
            ContextDropDownMenu,
            ReorderingList,
            ImageCaching
        ).sortedBy { it.title }
    }
}