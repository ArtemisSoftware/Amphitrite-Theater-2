package com.artemissoftware.amphitritetheater2.demo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable<Route.ContextDropDownMenu> {
            ContextDropDownScreen()
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

        composable<Route.Home> {
            DemoSelectorScreen(navController)
        }

    }

}