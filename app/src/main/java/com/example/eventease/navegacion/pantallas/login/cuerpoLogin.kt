package com.example.loginconocido_ngomalm2411.login

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eventease.componentes.buttonSubmit
import com.example.eventease.componentes.editText
import com.example.eventease.componentes.spacer
import com.example.eventease.componentes.texto

@Composable
fun cuerpoLogin(
    textoCorreo: String,
    textoContrasena: String,
    cambiarCorreo: (String) -> Unit,
    comprobarCorreo: Boolean,
    cambiarContra: (String) -> Unit,
    comprobarContra: Boolean,
    login: () -> Unit
) {
    editText(
        textoCorreo,
        { cambiarCorreo(it) },
        "Nombre de usuario",
        comprobarCorreo,
        15.dp,
        0.93f
    )
    spacer(8.dp)
    editText(
        textoContrasena,
        { cambiarContra(it) },
        "Contraseña",
        comprobarContra,
        15.dp,
        0.93f,
        PasswordVisualTransformation()
    )
    spacer(8.dp)
    buttonSubmit("Iniciar sesíon", { login() }, 0.93f)
    spacer(12.dp)
    texto(
        "¿Has olvidado la contraseña?",
        16.sp,
        FontWeight.Bold,
        Color.Black,
        TextAlign.Center,
        TextOverflow.Ellipsis,
        Modifier.Companion.padding(horizontal = 16.dp)
    )
}