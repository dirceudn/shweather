package com.org.sweather.core.home.domain.usecase

import com.org.sweather.core.home.domain.repository.WeatherRepository
import com.org.sweather.core.search.data.model.CityData


interface GetWeatherUsecase {
    suspend operator fun invoke(cityData: CityData)
}

fun getWeatherUseCase(repository: WeatherRepository): GetWeatherUsecase =
    object : GetWeatherUsecase {
        override suspend fun invoke(cityData: CityData) =
            repository.fetchWeather(cityData = cityData)
    }