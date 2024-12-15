package com.example.eventease.componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//funcion que me permite reutilizar codigo y muestra un producto y cuando clickas te lleva a ese producto
@Composable
fun cardCategorias(categoria:String,onClick: () -> Unit){
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        modifier = Modifier
            .size(width = 100.dp, height = 100.dp)
            .clickable { onClick() },
    ) {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "verdura",
                tint = Color.Black,
                modifier = Modifier.size(50.dp)
            )
            Text(categoria)
        }
    }
    }
}
//funcion que me sirve para mostrar mensaje y poder poner mas padding al texto y mas ancho la tarjeta

@Composable
@Preview
fun cardMensaje(titulo:String="usuario", mensaje:String= "Nicolas", anchoCard:Dp = 240.dp, altoCard:Dp= 100.dp){
        OutlinedCard(
            //le pongo color a la carta
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            //le redondeo las esquinas
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
            //le doy un ancho y un alto
            modifier = Modifier
                .size(width = anchoCard, height = altoCard),
        ) {
            Column(modifier = Modifier.padding(start = 3.dp, top = 2.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    icono(tamano = 35.dp)
                    texto(titulo,25.sp, align = TextAlign.Center)
                }
                texto(mensaje,14.sp)
            }


        }

}