package com.org.sweather.core.search.domain.repository

import com.org.sweather.core.common.State
import com.org.sweather.core.search.data.model.CityData
import com.org.sweather.core.search.data.model.CityDataModel
import kotlinx.coroutines.flow.Flow

interface SearchCityRepository {
    suspend fun fetchCities()
    suspend fun getCitiesFLow(): Flow<State<CityDataModel>>
}