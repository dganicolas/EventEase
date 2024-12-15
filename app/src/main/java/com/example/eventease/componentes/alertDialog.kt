package com.example.eventease.componentes

import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun ventanaModal(estadoVentana: Boolean, cerrar:() -> Unit,titulo:String,mensaje:String) {
    if (estadoVentana) {
        AlertDialog(
            onDismissRequest = { cerrar() },
            title = { texto(
                titulo,
                bold = FontWeight.Bold,
                color = Color.Black,
                align = TextAlign.Center
            ) }, // Opcional
            text = { texto(
                mensaje,
                color = Color.Black,
                align = TextAlign.Center
            ) },
            confirmButton = {
                buttonSubmit("Aceptar",{cerrar()})
            }
        )
    }
}