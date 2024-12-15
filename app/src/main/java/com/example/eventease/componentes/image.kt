package com.example.eventease.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp

@Composable
fun image(rutaImagen:Int, descripcion:String, tamano: Dp, contentScale: ContentScale = ContentScale.FillWidth, colorFilter: ColorFilter? = null){
    Image(
        painter = painterResource(rutaImagen),
        contentDescription = descripcion,
        modifier = Modifier.size(tamano),
        contentScale = contentScale,
        colorFilter = colorFilter
    )
}