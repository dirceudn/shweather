package com.org.sweather.core.home.domain.repository

import com.org.sweather.core.common.State
import com.org.sweather.core.home.data.model.WeatherDataOneCall
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getWeatherFlow(): Flow<State<WeatherDataOneCall>>
    suspend fun fetchWeather(lat: Double, lng: Double)

}