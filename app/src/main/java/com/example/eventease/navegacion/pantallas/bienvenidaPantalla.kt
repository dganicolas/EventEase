package com.example.eventease.navegacion.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.eventease.R
import com.example.eventease.componentes.button
import com.example.eventease.componentes.image
import com.example.eventease.componentes.texto
import com.example.eventease.ui.theme.colorBtn
import com.example.eventease.ui.theme.grayFondo

@Composable
@Preview
fun bienvenidaPantalla(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(grayFondo),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        image(R.drawable.logo, "Logo de la app", 120.dp)

        texto(
            "EventEase",
            35.sp,
            FontWeight.Bold,
            Color.Black,
            TextAlign.Center,
            TextOverflow.Ellipsis
        )

        texto(
            "Facilitando tus eventos, simplificando tus reservas",
            25.sp,
            FontWeight.Medium,
            Color.Black,
            TextAlign.Center,
            TextOverflow.Ellipsis,
        )

        // Botón para continuar
        button(
            { navController.navigate(route = "login") }, "Entrar", 20.sp,
            Modifier
                .padding(16.dp)
                .fillMaxWidth(0.8f)
                .height(50.dp),
            RoundedCornerShape(25.dp),
            ButtonDefaults.buttonColors(colorBtn)
        )


        // Espacio inferior
        Spacer(modifier = Modifier.height(50.dp))
    }
}