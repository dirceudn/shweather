package com.org.sweather.core.home.data.repository

import com.org.sweather.core.common.DefaultErrorEntity
import com.org.sweather.core.common.Either
import com.org.sweather.core.common.toEntity
import com.org.sweather.core.home.data.datasource.WeatherDataSource
import com.org.sweather.core.home.data.model.WeatherDataOneCall
import com.org.sweather.core.home.domain.repository.WeatherRepository

class WeatherRepositoryImpl(private val weatherDataSource: WeatherDataSource) : WeatherRepository {

    override suspend fun getWeather(
        lat: Double,
        lng: Double
    ): Either<DefaultErrorEntity, WeatherDataOneCall> {
        return weatherDataSource.getWeather(lat = lat, lng = lng).fold({
            Either.Left(it.toEntity())
        }, {
            Either.Right(it)
        })
    }
}