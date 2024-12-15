package com.example.eventease.navegacion.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.eventease.componentes.button
import com.example.eventease.componentes.cardMensaje
import com.example.eventease.componentes.spacer
import com.example.eventease.componentes.texto
import com.example.eventease.componentes.ventanaModal
import com.example.eventease.ui.theme.btnEliminar
import com.example.eventease.ui.theme.colorBtn
import com.example.eventease.ui.theme.grayFondo
import com.example.eventease.viewmodel.ViewModel

@Composable
@Preview
fun miPerfil(
    modifier: Modifier = Modifier,
    viewModel: ViewModel = ViewModel(),
    navControlador: NavHostController= rememberNavController()
) {
    val estadoVentana by viewModel.ventanaModal.observeAsState(false)
    val mensajeVentana by viewModel.tituloVentanaModal.observeAsState("")
    val tituloVentana by viewModel.mensajeVentanaModal.observeAsState("")
    val usuario by viewModel.textoUsuario.observeAsState("")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(grayFondo),
    ) {
        ventanaModal(estadoVentana, { viewModel.cerrarVentana() }, mensajeVentana, tituloVentana)
        Spacer(Modifier.size(15.dp))
        //mensaje que muestro que le sirve al usuario que esta demo no esta terminada
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            cardMensaje(
                mensaje = "bienvenido: $usuario"
            )
            spacer(10.dp)
            texto("¿Que quieres hacer hoy?")
            spacer(10.dp)
            button(
                {navControlador.navigate("formulario")}, "Actualizar mi informacion", 20.sp,
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth(0.8f)
                    .height(50.dp),
                RoundedCornerShape(25.dp),
                ButtonDefaults.buttonColors(colorBtn)
            )
            button(
                {navControlador.navigate("login")}, "borrar mi cuenta", 20.sp,
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth(0.8f)
                    .height(50.dp),
                RoundedCornerShape(25.dp),
                ButtonDefaults.buttonColors(btnEliminar)
            )
        }

    }
}