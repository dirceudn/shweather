package com.org.sweather.core.search.domain.usecase

import com.org.sweather.core.common.State
import com.org.sweather.core.search.data.model.CityDataModel
import com.org.sweather.core.search.domain.repository.SearchCityRepository
import kotlinx.coroutines.flow.Flow

interface CitiesStateFlow {
    suspend fun invoke(): Flow<State<CityDataModel>>
}

fun citiesStateFlow(repository: SearchCityRepository): CitiesStateFlow =
    object : CitiesStateFlow {
        override suspend fun invoke() =
            repository.getCitiesFLow()
    }