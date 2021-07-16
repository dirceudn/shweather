package com.org.sweather.core.home.domain.repository

import com.org.sweather.core.common.DefaultErrorEntity
import com.org.sweather.core.common.Either
import com.org.sweather.core.home.data.model.WeatherDataOneCall

interface WeatherRepository {
    suspend fun getWeather(lat: Double, lng: Double): Either<DefaultErrorEntity, WeatherDataOneCall>

}