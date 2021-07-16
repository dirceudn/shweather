package com.org.sweather.core.home.data.datasource

import com.org.sweather.core.common.DefaultErrorDataModel
import com.org.sweather.core.common.Either
import com.org.sweather.core.home.data.model.WeatherDataOneCall

interface WeatherDataSource {

    suspend fun getWeather(
        lat: Double,
        lng: Double
    ): Either<DefaultErrorDataModel, WeatherDataOneCall>
}