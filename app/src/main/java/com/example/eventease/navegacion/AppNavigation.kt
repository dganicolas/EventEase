package com.example.eventease.navegacion

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eventease.navegacion.pantallas.ScaffoldExample
import com.example.eventease.navegacion.pantallas.bienvenidaPantalla
import com.example.eventease.navegacion.pantallas.formulario
import com.example.eventease.navegacion.pantallas.login.login
import com.example.eventease.navegacion.pantallas.miPerfil
import com.example.eventease.navegacion.pantallas.misLocales
import com.example.eventease.navegacion.pantallas.misReservas
import com.example.eventease.viewmodel.ViewModel

@Composable
fun AppNavigation(modifier: Modifier,viewModel: ViewModel) {
    //este es mi modo de navegacion mediante el navhost controlo todas las pantallas de forma directa
    val navControlador = rememberNavController()

    NavHost(navController = navControlador, startDestination = "bienvenida") {
        //pantalla principal y la que se va a abrir al iniciar la app
        composable("bienvenida") {
            bienvenidaPantalla(modifier, navControlador)
        }
        //menu principal que es la categorias directamente
        composable(
            "login"
        ) {
            viewModel.pantallaLogin()
            login(modifier, viewModel,navControlador)
        }
        composable(
            "mis reservas"
        ) {
            ScaffoldExample(modifier,navControlador, { misReservas(modifier, viewModel,navControlador) })
        }
        composable(
            "mis locales"
        ) {
            ScaffoldExample(modifier,navControlador, { misLocales(viewModel, navControlador) })
        }
        composable(
            "mi perfil"
        ) {
            ScaffoldExample(modifier,navControlador, { miPerfil(modifier, viewModel,navControlador) })
        }
        composable(
            "formulario"
        ) {
            ScaffoldExample(modifier,navControlador, { formulario(modifier, viewModel,navControlador) })
        }

    }
}