package com.org.sweather.ui.design

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.org.sweather.ui.warmFlameStart


@Composable
fun SnackBarCity(city: String, goBack: () -> Unit) {
    Snackbar(
        backgroundColor = warmFlameStart,
        action = {
            Text("Back", style = MaterialTheme.typography.subtitle1.copy(
                color = Color.White,
                fontSize = 12.sp
            ), modifier = Modifier.clickable {
                goBack()
            })
        },
        modifier = Modifier.padding(12.dp)
    ) {
        Text(
            text = if (city.isNotEmpty()) "Your city was found $city" else "City not found",
            style = MaterialTheme.typography.subtitle1.copy(
                color = Color.White,
                fontSize = 12.sp
            ),
        )
    }
}
