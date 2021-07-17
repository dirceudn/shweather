package com.org.sweather.home.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.org.sweather.home.model.WeatherUiModel
import com.org.sweather.home.viewmodel.HomeViewModel
import com.org.sweather.ui.date.getDateTime
import kotlinx.coroutines.InternalCoroutinesApi


@OptIn(InternalCoroutinesApi::class)
@Preview(showBackground = true)
@Composable
fun HomeScreen(homeViewMode: HomeViewModel) {

    val weatherUiModelState = homeViewMode.weatherUiStateFlow.collectAsState()

    Box() {
        WeatherPage(weatherUiMode = weatherUiModelState.value)
    }
}


@Composable
fun WeatherPage(weatherUiMode: WeatherUiModel?) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 45.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(text = "Limeil-Brevannes")
        Spacer(modifier = Modifier.size(24.dp))
        Text(weatherUiMode?.date?.getDateTime() ?: "--")
        Spacer(modifier = Modifier.size(34.dp))
        Text("${weatherUiMode?.mainTemperature}º", style = TextStyle(fontSize = 48.sp))
        Spacer(modifier = Modifier.size(34.dp))
        Text(weatherUiMode?.description ?: "--", style = TextStyle(fontSize = 20.sp))
    }

}