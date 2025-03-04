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

    @Serializable
    object ListSwipe

    @Serializable
    object BouncingBall

    @Serializable
    object CircleReveal

    @Serializable
    object CustomScaffold

    @Serializable
    object ClippedCircle

    @Serializable
    object DaggerWheelPicker

    @Serializable
    object CustomShapes
}

sealed class Destination(val title: String) {
    data object Home : Destination(title = "Demo")
    data object PaymentCard : Destination(title = "Payment Card")
    data object ContextDropDownMenu : Destination(title = "Context Drop Down Menu")
    data object ReorderingList : Destination(title = "Reordering List")
    data object ImageCaching : Destination(title = "Image Caching")
    data object ListSwipe : Destination(title = "Custom Swipe to Reveal")
    data object BouncingBall : Destination(title = "Bouncing Ball animation")
    data object CircleReveal : Destination(title = "Circle Reveal Animation On Pager")
    data object CustomScaffold : Destination(title = "Custom - Scaffold")
    data object ClippedCircle : Destination(title = "Clipped Circle")
    data object DaggerWheelPicker : Destination(title = "Dagger Wheel Picker")
    data object CustomShapes : Destination(title = "Custom Shapes")

    companion object{

        fun getRoute(destination: Destination): Any {

            return when(destination){
                PaymentCard -> Route.PaymentCard
                ContextDropDownMenu -> Route.ContextDropDownMenu
                ReorderingList -> Route.ReorderingList
                ImageCaching -> Route.ImageCaching
                ListSwipe -> Route.ListSwipe
                BouncingBall -> Route.BouncingBall
                CircleReveal -> Route.CircleReveal
                CustomScaffold -> Route.CustomScaffold
                ClippedCircle -> Route.ClippedCircle
                DaggerWheelPicker -> Route.DaggerWheelPicker
                CustomShapes -> Route.CustomShapes
                else -> Route.Home
            }
        }

        val demos = listOf(
            PaymentCard,
            ContextDropDownMenu,
            ReorderingList,
            ImageCaching,
            ListSwipe,
            BouncingBall,
            CircleReveal,
            CustomScaffold,
            ClippedCircle,
            DaggerWheelPicker,
            CustomShapes
        ).sortedBy { it.title }
    }
}