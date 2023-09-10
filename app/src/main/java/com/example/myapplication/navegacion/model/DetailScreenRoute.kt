package com.example.myapplication.navegacion.model

sealed class DetailScreenRoute(val route: String){

    object Detail : DetailScreenRoute("detail/{eventId}")
}
