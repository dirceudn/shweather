package com.org.sweather.core.home.domain.usecase

import com.org.sweather.core.home.domain.repository.WeatherRepository


interface GetWeatherUsecase {
    suspend operator fun invoke(lat: Double, lng: Double)
}

fun getWeatherUseCase(repository: WeatherRepository): GetWeatherUsecase =
    object : GetWeatherUsecase {
        override suspend fun invoke(lat: Double, lng: Double) =
            repository.fetchWeather(lat = lat, lng = lng)
    }