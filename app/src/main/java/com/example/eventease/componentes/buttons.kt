package com.example.eventease.componentes

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eventease.ui.theme.colorBtn
import com.example.eventease.ui.theme.blancoTextoBoton
import com.example.eventease.ui.theme.fondoLogin
import com.example.eventease.ui.theme.textoBtnCrearCuenta

@Composable
fun buttonSubmit(texto:String, accion:()-> Unit, ancho:Float=1f,){
    Button(
        modifier = Modifier.fillMaxWidth(ancho),
        onClick = {
            accion()
        },
        colors = ButtonColors(colorBtn, blancoTextoBoton, Color.Blue, Color.Blue)
    ) {
        texto(
            texto,
            16.sp,
            FontWeight.Bold,
            Color.White,
            TextAlign.Center,
            TextOverflow.Ellipsis,
            Modifier.Companion.padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun buttonNewAccount(texto:String,accion:()->Unit,ancho: Float){
    Button(
        modifier = Modifier
            .fillMaxWidth(ancho)
            .border(2.dp, textoBtnCrearCuenta, shape = RoundedCornerShape(30.dp)),
        onClick = { accion() },
        colors = ButtonColors(fondoLogin, textoBtnCrearCuenta, Color.Blue, Color.Blue)
    ) {
        Text(
            text = texto,
            fontSize = 16.sp
        )
    }
}