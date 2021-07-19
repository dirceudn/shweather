package com.org.sweather.core.home.domain.repository

import com.org.sweather.core.search.data.model.CityData

interface CitySavedRepository {

    fun citySaved(): CityData
}