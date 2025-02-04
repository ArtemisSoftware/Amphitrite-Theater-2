package com.artemissoftware.amphitritetheater2.demo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.artemissoftware.amphitritetheater2.demo.DemoSelectorScreen
import com.artemissoftware.amphitritetheater2.paymentcard.PaymentCardScreen

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


        composable<Route.PaymentCard> {
            PaymentCardScreen()
        }

        composable<Route.Home> {
            DemoSelectorScreen(navController)
        }

    }

}