package com.artemissoftware.amphitritetheater2.demo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.artemissoftware.amphitritetheater2.animation.androidlogo.AndroidLogoScreen
import com.artemissoftware.amphitritetheater2.ar.ArScreen
import com.artemissoftware.amphitritetheater2.ar.ZoomableScreen
import com.artemissoftware.amphitritetheater2.bouncingball.BouncingBallScreen
import com.artemissoftware.amphitritetheater2.chart.bar.BarGraphScreen
import com.artemissoftware.amphitritetheater2.circlereveal.CircleRevealScreen
import com.artemissoftware.amphitritetheater2.clippedcircle.ClippedCircleScreen
import com.artemissoftware.amphitritetheater2.custom.CustomScaffoldScreen
import com.artemissoftware.amphitritetheater2.custom.CustomScaffoldViewModel
import com.artemissoftware.amphitritetheater2.customshapes.CustomShapesScreen
import com.artemissoftware.amphitritetheater2.daggerwheelpicker.DaggerWheelPickerScreen
import com.artemissoftware.amphitritetheater2.demo.DemoSelectorScreen
import com.artemissoftware.amphitritetheater2.dropdownmenu.ContextDropDownScreen
import com.artemissoftware.amphitritetheater2.imagecaching.ImageCachingScreen
import com.artemissoftware.amphitritetheater2.listswipe.ListSwipeScreen
import com.artemissoftware.amphitritetheater2.paymentcard.PaymentCardScreen
import com.artemissoftware.amphitritetheater2.reorderinglist.ReorderingListScreen

@Composable
fun DemoNavGraph(
    startDestination: Any = Route.Home,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    customScaffoldStateViewModel: CustomScaffoldViewModel
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable<Route.AndroidLogoAnimation> {
            AndroidLogoScreen()
        }

        composable<Route.ArView> {
            ArScreen()
        }

        composable<Route.BouncingBall> {
            BouncingBallScreen()
        }

        composable<Route.ChartBar> {
            BarGraphScreen()
        }

        composable<Route.CircleReveal> {
            CircleRevealScreen()
        }

        composable<Route.ClippedCircle> {
            ClippedCircleScreen()
        }

        composable<Route.ContextDropDownMenu> {
            ContextDropDownScreen()
        }

        composable<Route.CustomScaffold> {
            CustomScaffoldScreen(viewModel = customScaffoldStateViewModel)
        }

        composable<Route.CustomShapes> {
            CustomShapesScreen()
        }

        composable<Route.DaggerWheelPicker> {
            DaggerWheelPickerScreen()
        }

        composable<Route.ImageCaching> {
            ImageCachingScreen()
        }

        composable<Route.ListSwipe> {
            ListSwipeScreen()
        }

        composable<Route.PaymentCard> {
            PaymentCardScreen()
        }

        composable<Route.ReorderingList> {
            ReorderingListScreen()
        }

        composable<Route.Zoom> {
            ZoomableScreen()
        }

        composable<Route.Home> {
            DemoSelectorScreen(navController)
        }

    }

}