package com.org.sweather.core.home.api.network

import com.org.sweather.core.common.launchRequest
import com.org.sweather.core.home.api.model.WeatherNetworkModel
import com.org.sweather.core.home.data.datasource.WeatherDataSource
import com.org.sweather.core.home.data.model.toDataModel

class NetworkWeatherDataSource(private val openWeatherApi: OpenWeatherApi) : WeatherDataSource {

    override suspend fun getWeather(lat: Double, lng: Double) = launchRequest<WeatherNetworkModel> {
        request = {
            openWeatherApi.fetchWeather(unit = "metric", lat = lat, lng = lng)
        }
    }.map {
        it.toDataModel()
    }
}