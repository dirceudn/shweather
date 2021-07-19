package com.org.sweather.core.home.data.datasource

import com.org.sweather.core.common.DefaultErrorDataModel
import com.org.sweather.core.common.Either
import com.org.sweather.core.home.data.model.WeatherDataOneCall
import com.org.sweather.core.search.data.model.CityData

interface WeatherDataSource {

    suspend fun getWeather(
        cityData: CityData
    ): Either<DefaultErrorDataModel, WeatherDataOneCall>
}