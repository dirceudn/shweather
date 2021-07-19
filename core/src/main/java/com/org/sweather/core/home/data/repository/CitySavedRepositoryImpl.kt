package com.org.sweather.core.home.data.repository

import com.org.sweather.core.ModelPreferenceContract
import com.org.sweather.core.home.domain.repository.CitySavedRepository
import com.org.sweather.core.search.data.model.CityData

class CitySavedRepositoryImpl(private val preferenceContract: ModelPreferenceContract) :
    CitySavedRepository {
    override fun citySaved(): CityData {
        return preferenceContract.get(ModelPreferenceContract.KEY_CITY) ?: cityDefault
    }

    companion object {
        val cityDefault = CityData(
            city = "Paris",
            lat = "48.8566",
            lng = "2.3522",
            id = "",
            locationType = ""
        )
    }
}