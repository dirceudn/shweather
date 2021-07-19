package com.org.sweather.home.model

import com.org.sweather.core.home.data.model.DailyWeatherData
import com.org.sweather.core.home.data.model.WeatherDataOneCall


typealias WeatherUiModel = EmptyWeather

data class EmptyWeather(
    val id: String? = "???",
    val city: String = "???",
    val date: Long = 0L,
    val mainTemperature: String = "???",
    val description: String = "???",
    val dailyUiModel: List<DailyUiModel?> = emptyList()
)

fun WeatherDataOneCall.toUiModel() = WeatherUiModel(
    id = id,
    city = "$city",
    date = weather?.time ?: 0L,
    mainTemperature = "${weather?.temperature?.toInt()}",
    description = "${weather?.weather?.get(0)?.description}",
    dailyUiModel = dailyWeather.map { it?.toDailyUiModel() }

)

data class DailyUiModel(
    val date: Long? = 0L,
    val icon: String,
    val max: String,
    val min: String
)

fun DailyWeatherData.toDailyUiModel() = DailyUiModel(
    date = time,
    icon = weather?.get(0)?.icon ?: "",
    max = "${temperatureResume?.max?.toInt()}",
    min = "${temperatureResume?.min?.toInt()}"
)