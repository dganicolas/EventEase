package com.example.eventease.componentes

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

//para ahorrarme declarar el modifier, me ahorro lineas
@Composable
fun spacer(espacio:Dp = 20.dp){
    Spacer(Modifier.size(espacio))
}