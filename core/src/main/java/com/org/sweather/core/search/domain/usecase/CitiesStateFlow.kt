package com.org.sweather.core.search.domain.usecase

import com.org.sweather.core.search.domain.repository.SearchCityRepository
import kotlinx.coroutines.flow.Flow

interface CitiesStateFlow {
     suspend operator fun invoke(): Flow<Boolean>
}

fun citiesStateFlow(repository: SearchCityRepository): CitiesStateFlow =
    object : CitiesStateFlow {
        override suspend fun invoke() =
            repository.getCitiesFLow()
    }