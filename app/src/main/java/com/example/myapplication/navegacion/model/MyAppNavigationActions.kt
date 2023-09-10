package com.example.myapplication.navegacion.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.myapplication.R


class MyAppNavigationActions(private val navController: NavHostController) {
    fun navigateTo(destination: MyAppTopLevelDestination){
        navController.navigate(destination.route){
            popUpTo(navController.graph.findStartDestination().id){
                saveState = true
            }
            launchSingleTop = true //evitar crear multiples copias de la misma direccion
        }
    }
}

data class MyAppTopLevelDestination(val route: String, val selectedIcon: ImageVector, val iconTextId: Int)

val TOP_LEVEL_DESTINATIONS = listOf(
    MyAppTopLevelDestination(
        route = MyAppRoute.Home,
        selectedIcon = Icons.Default.Home,
        iconTextId = R.drawable.calendario
    ),


            MyAppTopLevelDestination(
            route = MyAppRoute.Favorites,
    selectedIcon = Icons.Default.Star,
    iconTextId = R.drawable.favorito
),

    MyAppTopLevelDestination(
        route = MyAppRoute.Places,
        selectedIcon = Icons.Default.Info,
        iconTextId = R.drawable.notificacion

    ),

    MyAppTopLevelDestination(
        route = MyAppRoute.Profile,
        selectedIcon = Icons.Default.Person,
        iconTextId = R.drawable.iconusuarioperfil

    ),



)

object MyAppRoute{
    const val Home = "home"
    const val Favorites = "Favorites"
    const val Places = "Places"
    const val Profile = "Profile"
    const val Detail = "detalle/{eventId}"
}