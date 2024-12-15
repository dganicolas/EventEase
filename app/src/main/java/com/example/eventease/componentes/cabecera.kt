package com.example.eventease.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.eventease.R
import com.example.eventease.ui.theme.btnEliminar
import com.example.eventease.ui.theme.colorBtn

@Preview
@Composable
fun cabecera(navController: NavController = rememberNavController()) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(com.example.eventease.ui.theme.cabecera)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            //imagen y nombre de la app
            image(R.drawable.logo, "logo de la app", 45.dp)
            Text(text = "Eventeease", fontSize = 16.sp)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(3.dp, Alignment.CenterHorizontally)
        ) {
            //cuando clickas te lleva a la pantalla principal que son categorias
            button(
                onClick = {
                    navController.navigate(route = "mi perfil")
                }, "Mi perfil", 13.sp,
                roundedCornerShape = RoundedCornerShape(25.dp),
                buttonColors = ButtonDefaults.buttonColors(colorBtn)
            )
            //cuando clickas te lleva a la pantalla principal de construccion
            button(
                onClick = {
                    navController.navigate(route = "mis locales")
                }, "Mis locales", 13.sp,
                roundedCornerShape = RoundedCornerShape(25.dp),
                buttonColors = ButtonDefaults.buttonColors(colorBtn)
            )
            //cuando clickas te lleva a la pantalla de construccion
            button(
                onClick = {
                    navController.navigate(route = "mis reservas")
                }, "Mis reservas", 13.sp,
                roundedCornerShape = RoundedCornerShape(25.dp),
                buttonColors = ButtonDefaults.buttonColors(colorBtn)
            )
            //cuando clickas te lleva a la pantalla de construccion
            button(
                onClick = {
                    navController.navigate(route = "login")
                }, "salir", 13.sp,
                roundedCornerShape = RoundedCornerShape(25.dp),
                buttonColors = ButtonDefaults.buttonColors(btnEliminar)

            )
        }


    }
}