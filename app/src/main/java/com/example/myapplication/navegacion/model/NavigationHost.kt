package com.example.myapplication.navegacion.model

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.ui.theme.ui.Detalle.DetailScreen
import com.example.myapplication.EventGrid
import com.example.myapplication.ui.theme.ui.ListaFavoritos.ListFavEvents
import com.example.myapplication.ui.theme.ui.Perfil.Profile
import com.example.myapplication.events
import com.example.myapplication.ui.theme.ui.CardItem
import com.example.myapplication.ui.theme.ui.themePlaceList.ListPlaces

@Composable
fun NavigationHost(navController: NavController){

    NavHost(navController = navController as NavHostController, startDestination = Items_menu.Pantalla1.ruta  ){
     composable(Items_menu.Pantalla1.ruta){
         EventGrid(modifier = Modifier ,navController)
     }

        composable(Items_menu.Pantalla2.ruta){
           ListFavEvents()
        }

        composable(Items_menu.Pantalla3.ruta){
            ListPlaces()
        }


        composable(Items_menu.Pantalla4.ruta){
            Profile()
        }
        fun findEventById(eventId: String?): CardItem? {
            return events.firstOrNull { it.id == eventId }
        }

        composable("detalle/{eventId}") { backStackEntry ->
            val eventId = backStackEntry.arguments?.getString("eventId")
            val cardItem = findEventById(eventId)
            if (cardItem != null) {
                DetailScreen(cardItem,modifier = Modifier,navController)
            } else {
                Log.d("ERROR", "Entramos al ELSE , carditem es NULL")
            }
        }



    }





}