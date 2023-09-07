package com.example.myapplication.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Navigation(modifier: Modifier){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = NavigationState.Home.route,
        modifier = modifier) {
        composable(route = NavigationState.Home.route) {
            EventGrid(
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)),
                navController = navController
            )
        }
        composable(route = NavigationState.Detail.route) {
            Detail(navController = navController)
        }
        composable(route = NavigationState.Events.route) {
            MainScreen(navController = navController)
        }
        composable(route = NavigationState.Profile.route) {
            Profile(navController = navController)
        }
    }
}