package com.example.myapplication.navegacion.model

import com.example.myapplication.R


sealed class Items_menu(
    val icon: Int,
    val title: String,
    val ruta: String


){
    object Pantalla1: Items_menu(R.drawable.calendario,"Eventos","pantalla1")

    object Pantalla2: Items_menu(R.drawable.favorito,"Favoritos","pantalla2")

    object Pantalla3: Items_menu(R.drawable.favorito,"ListaLugares","pantalla3")

    object Pantalla4: Items_menu(R.drawable.favorito,"Perfil","pantalla4")

    object Pantalla5: Items_menu(R.drawable.notificacion,"Detalle","detalle/{eventId}")
}
