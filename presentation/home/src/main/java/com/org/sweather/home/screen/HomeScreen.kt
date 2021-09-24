package com.org.sweather.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.org.sweather.home.model.DailyUiModel
import com.org.sweather.home.model.WeatherUiModel
import com.org.sweather.home.viewmodel.HomeViewModel
import com.org.sweather.ui.date.getDateTime
import com.org.sweather.ui.date.getDayOfWeek
import com.org.sweather.ui.design.DailyWeatherItem
import com.org.sweather.ui.thme.font
import com.org.sweather.ui.transparent
import kotlinx.coroutines.InternalCoroutinesApi


@OptIn(InternalCoroutinesApi::class)
@Composable
fun HomeScreen(homeViewMode: HomeViewModel) {

    val weatherUiModelState = homeViewMode.weatherUiStateFlow.collectAsState()

    Box(Modifier.fillMaxSize()) {
        WeatherPage(weatherUiMode = weatherUiModelState.value)
    }
}


@Composable
fun WeatherPage(weatherUiMode: WeatherUiModel?) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            Modifier
                .background(transparent)
                .height(120.dp)
        )
        Text(
            "${weatherUiMode?.mainTemperature}º",
            style = TextStyle(fontSize = 68.sp, color = Color.White),
            fontFamily = font,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            weatherUiMode?.description ?: "--",
            style = TextStyle(
                fontSize = 26.sp,
                color = Color.White,
                fontFamily = font,
                fontWeight = FontWeight.Normal
            ),

            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.size(44.dp))
        Text(
            text = weatherUiMode?.city ?: "--",
            style = TextStyle(
                fontSize = 18.sp,
                color = Color.White,
                fontFamily = font,
                fontWeight = FontWeight.Normal
            )
        )
        Text(
            weatherUiMode?.date?.getDateTime() ?: "--",
            style = TextStyle(
                fontSize = 18.sp,
                color = Color.White,
                fontFamily = font,
                fontWeight = FontWeight.Normal
            )
        )
        Spacer(modifier = Modifier.size(34.dp))
        DailyWeather(dailyWeatherList = weatherUiMode?.dailyUiModel)
    }

}

@Composable
fun DailyWeather(
    dailyWeatherList: List<DailyUiModel?>?
) {
    dailyWeatherList?.let { weeklyWeatherlist ->
        LazyRow(content = {
            if(weeklyWeatherlist.isNotEmpty()){
                items(weeklyWeatherlist.subList(0, 5)) { item ->
                    item?.let { dailyItem ->
                        DailyWeatherItem(
                            icon = dailyItem.icon,
                            min = dailyItem.min,
                            max = dailyItem.max,
                            date = dailyItem.date?.getDayOfWeek() ?: "--"
                        )
                    }
                }
            }
        }, horizontalArrangement = Arrangement.Center)
    }

}
