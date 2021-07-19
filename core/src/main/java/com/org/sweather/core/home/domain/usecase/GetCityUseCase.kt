package com.org.sweather.core.home.domain.usecase

import com.org.sweather.core.home.domain.repository.CitySavedRepository
import com.org.sweather.core.search.data.model.CityData

interface GetCitySavedUseCase {
    operator fun invoke(): CityData
}

fun getCitySavedUseCase(repository: CitySavedRepository): GetCitySavedUseCase =
    object : GetCitySavedUseCase {
        override operator fun invoke() =
            repository.citySaved()
    }