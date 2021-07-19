package com.org.sweather.core.search.domain.usecase

import com.org.sweather.core.search.domain.repository.SearchCityRepository

interface GetCitiesUseCase {
    suspend operator fun invoke()
}

fun getCitiesUseCase(repository: SearchCityRepository): GetCitiesUseCase =
    object : GetCitiesUseCase {
        override suspend fun invoke() =
            repository.fetchCities()
    }