package com.example.eventease.navegacion.pantallas.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eventease.R
import com.example.eventease.componentes.buttonSubmit
import com.example.eventease.componentes.image
import com.example.eventease.componentes.spacer
import com.example.eventease.componentes.texto

@Composable
fun pieLogin(
    modifier: Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        //boton crear cuenta
        buttonSubmit("Crear cuenta nueva", {}, 0.93f)
        spacer(13.dp)
        image(R.drawable.logo,"logo Principal",56.dp)
        Row {
            texto(
                "Información",
                12.sp,
                FontWeight.Bold,
                Color.Black,
                TextAlign.Center,
                TextOverflow.Ellipsis,
                Modifier.Companion.padding(horizontal = 16.dp)
            )
            spacer(13.dp)
            texto(
                "Ayuda",
                12.sp,
                FontWeight.Bold,
                Color.Black,
                TextAlign.Center,
                TextOverflow.Ellipsis,
                Modifier.Companion.padding(horizontal = 16.dp)
            )
            spacer(13.dp)
            texto(
                "Más",
                12.sp,
                FontWeight.Bold,
                Color.Black,
                TextAlign.Center,
                TextOverflow.Ellipsis,
                Modifier.Companion.padding(horizontal = 16.dp)
            )
        }
    }
}