package com.example.eventease.componentes

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun icono(
    icono: ImageVector = Icons.Filled.AccountCircle,
    tamano: Dp = 24.dp,
    contenidoDescripcion: String? = null,
    colorIcono: Color = Color.Black
) {
        Icon(
            imageVector = icono,
            contentDescription = contenidoDescripcion,
            modifier = Modifier.size(tamano),
            tint = colorIcono
        )
}