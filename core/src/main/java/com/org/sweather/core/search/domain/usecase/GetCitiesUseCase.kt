package com.org.sweather.core.search.domain.usecase

import com.org.sweather.core.search.domain.repository.SearchCityRepository

interface GetCitiesUseCase {
    suspend operator fun invoke(query: String)
}

fun getCitiesUseCase(repository: SearchCityRepository): GetCitiesUseCase =
    object : GetCitiesUseCase {
        override suspend fun invoke(query: String) =
            repository.fetchCities(query = query)
    }