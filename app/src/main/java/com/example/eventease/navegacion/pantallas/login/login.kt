package com.example.eventease.navegacion.pantallas.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.eventease.componentes.ventanaModal
import com.example.eventease.ui.theme.grayFondo
import com.example.eventease.viewmodel.ViewModel
import com.example.loginconocido_ngomalm2411.login.cuerpoLogin


@Preview
@Composable
fun login(
    modifier: Modifier = Modifier,
    viewModel: ViewModel = ViewModel(),
    navControlador: NavHostController
) {
    val textoIdioma by viewModel.textoIdioma.observeAsState("")
    val textoCorreo by viewModel.textoUsuario.observeAsState("")
    val textoContraseña by viewModel.textoContrasena.observeAsState("")
    val estadoVentana by viewModel.ventanaModal.observeAsState(false)
    val mensajeVentana by viewModel.tituloVentanaModal.observeAsState("")
    val tituloVentana by viewModel.mensajeVentanaModal.observeAsState("")
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(grayFondo),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        cabeceraLogin(
            textoIdioma = textoIdioma,
        )
        ventanaModal(estadoVentana, { viewModel.cerrarVentana() },mensajeVentana,tituloVentana)
        cuerpoLogin(
            textoCorreo = textoCorreo,
            textoContrasena =  textoContraseña,
            cambiarCorreo = { viewModel.cambiarCorreo(it) },
            comprobarCorreo =  viewModel.comprobarCorreo(textoCorreo),
            cambiarContra = { viewModel.cambiarContrasena(it) },
            comprobarContra = viewModel.comprobarContrasena(textoContraseña),
            login = { navControlador.navigate("mi perfil")})
        pieLogin(Modifier.weight(1f))
    }
}