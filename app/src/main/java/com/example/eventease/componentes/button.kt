package com.example.eventease.componentes

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//funcion que me permite reutilizar codigo, asi ahorrandome unas cuantas lineas
//el parametro on click hara el boton lo que se le pase por parametro
@Composable
fun button(
    onClick: () -> Unit,
    text: String,
    tamanoTexto: TextUnit = 20.sp,
    modifier: Modifier = Modifier,
    roundedCornerShape: RoundedCornerShape = RoundedCornerShape(8.dp),
    buttonColors: ButtonColors = ButtonDefaults.buttonColors()
){
    Button(

        onClick = {
            onClick()
        },
        modifier = modifier,
        shape = roundedCornerShape,
        colors = buttonColors
    ){
        Text(text = text,fontSize = tamanoTexto)
    }
}
