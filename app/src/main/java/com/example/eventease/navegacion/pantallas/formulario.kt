package com.example.eventease.navegacion.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.eventease.componentes.button
import com.example.eventease.componentes.editText
import com.example.eventease.componentes.icono
import com.example.eventease.componentes.spacer
import com.example.eventease.componentes.ventanaModal
import com.example.eventease.ui.theme.colorBtn
import com.example.eventease.ui.theme.grayFondo
import com.example.eventease.viewmodel.ViewModel

@Composable
@Preview
fun formulario(
    modifier: Modifier = Modifier,
    viewModel: ViewModel = ViewModel(),
    navControlador: NavHostController
) {

    val estadoVentana by viewModel.ventanaModal.observeAsState(false)
    val mensajeVentana by viewModel.tituloVentanaModal.observeAsState("")
    val tituloVentana by viewModel.mensajeVentanaModal.observeAsState("")
    val username by viewModel.textoUsuario.observeAsState("")
    val contrasena by viewModel.textoContrasena.observeAsState("")

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(grayFondo),
        verticalArrangement = Arrangement.Top
    ) {
        ventanaModal(estadoVentana, { viewModel.cerrarVentana() }, mensajeVentana, tituloVentana)
        spacer(20.dp)
        // Formulario
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Campo para el username

            editText(
                texto = username,
                cambioTexto = { viewModel.cambiarCorreo(it) },
                marcador = "Nombre de usuario",
                infoError = username.isNotBlank(),
            )

            spacer(10.dp)

            // Campo para el password
            editText(
                texto = contrasena,
                cambioTexto = { viewModel.cambiarContrasena(it) },
                marcador = "Nombre de usuario",
                infoError = contrasena.isNotBlank(),
            )

            spacer(20.dp)

            // Botón de actualizar
            button(
                onClick = {
                    viewModel.mostrarEndpoint(
                        titulo = "/usuarios/actualizarusuario",
                        mensaje = "Actualizar usuario: $username"
                    )
                },
                text = "Actualizar usuario",
                tamanoTexto = 18.sp,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp),
                roundedCornerShape = RoundedCornerShape(25.dp),
                buttonColors = ButtonDefaults.buttonColors(colorBtn)
            )
        }
    }
}