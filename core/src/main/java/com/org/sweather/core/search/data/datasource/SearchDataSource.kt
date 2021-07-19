package com.org.sweather.core.search.data.datasource

import com.org.sweather.core.common.DefaultErrorDataModel
import com.org.sweather.core.common.Either
import com.org.sweather.core.home.data.model.WeatherDataOneCall
import com.org.sweather.core.search.data.model.CityData
import com.org.sweather.core.search.data.model.CityDataModel

interface SearchDataSource {
    suspend fun getCities(query:String
    ): Either<DefaultErrorDataModel, CityDataModel>
}