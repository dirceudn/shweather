package com.org.sweather.core.home.domain.usecase

import com.org.sweather.core.common.State
import com.org.sweather.core.home.data.model.WeatherDataOneCall
import com.org.sweather.core.home.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow

interface WeatherStateFlow {
    suspend fun invoke(): Flow<State<WeatherDataOneCall>>
}

fun getWeatherFlow(repository: WeatherRepository): WeatherStateFlow =
    object : WeatherStateFlow {
        override suspend fun invoke() =
            repository.getWeatherFlow()
    }