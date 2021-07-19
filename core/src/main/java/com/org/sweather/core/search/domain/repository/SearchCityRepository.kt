package com.org.sweather.core.search.domain.repository

import com.org.sweather.core.common.State
import com.org.sweather.core.search.data.model.CityStatus
import kotlinx.coroutines.flow.Flow

interface SearchCityRepository {
    suspend fun fetchCities(query: String)
    suspend fun getCitiesFLow(): Flow<State<CityStatus>>
}