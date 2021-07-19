package com.org.sweather.core.home.data.repository

import com.org.sweather.core.common.State
import com.org.sweather.core.home.data.datasource.WeatherDataSource
import com.org.sweather.core.home.data.model.WeatherDataOneCall
import com.org.sweather.core.home.domain.repository.WeatherRepository
import com.org.sweather.core.search.data.model.CityData
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class WeatherRepositoryImpl(
    private val weatherDataSource: WeatherDataSource
) : WeatherRepository {


    private val weatherDataMutableStateFlow =
        MutableStateFlow<State<WeatherDataOneCall>>(State.Uninitialized(null))

    override suspend fun getWeatherFlow(): Flow<State<WeatherDataOneCall>> =
        weatherDataMutableStateFlow

    @DelicateCoroutinesApi
    override suspend fun fetchWeather(
        cityData: CityData
    ) {
        if (weatherDataMutableStateFlow.value !is State.Loading) {
            weatherDataMutableStateFlow.value = State.Loading(null)
            weatherDataMutableStateFlow.value =
                weatherDataSource.getWeather(cityData = cityData).fold({
                    State.Failure(data = weatherDataMutableStateFlow.value())
                }, { weatherDataOneCall ->
                    State.Success(data = weatherDataOneCall)
                })
        }
    }


}