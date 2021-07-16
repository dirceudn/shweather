package com.org.sweather.home.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        WeatherPage()
    }
}


@Composable
fun WeatherPage() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 45.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(text = "City")
        Spacer(modifier = Modifier.size(4.dp))
        Text("Date")
        Spacer(modifier = Modifier.size(4.dp))
        Text("Temperature")
    }

}