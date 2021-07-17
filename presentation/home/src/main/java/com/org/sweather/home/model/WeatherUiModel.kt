package com.org.sweather.home.model

import com.org.sweather.core.home.data.model.WeatherDataOneCall


typealias WeatherUiModel = EmptyWeather

data class EmptyWeather(
    val id: String? = "???",
    val city: String = "???",
    val date: Long = 0L,
    val mainTemperature: String = "???",
    val description: String = "???"
)

fun WeatherDataOneCall.toUiModel() = WeatherUiModel(
    id = id,
    city = "$city",
    date = weather?.time ?: 0L,
    mainTemperature = "${weather?.temperature?.toInt()}",
    description = "${weather?.weather?.get(0)?.main}"

)