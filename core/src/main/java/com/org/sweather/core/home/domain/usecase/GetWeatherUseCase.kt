package com.org.sweather.core.home.domain.usecase

import com.org.sweather.core.home.domain.repository.WeatherRepository
import com.org.sweather.core.search.data.model.CityData


interface GetWeatherUseCase {
    suspend operator fun invoke(cityData: CityData)
}

fun getWeatherUseCase(repository: WeatherRepository): GetWeatherUseCase =
    object : GetWeatherUseCase {
        override suspend fun invoke(cityData: CityData) =
            repository.fetchWeather(cityData = cityData)
    }