package com.org.sweather.core.search.data.repository

import com.org.sweather.core.ModelPreferenceContract
import com.org.sweather.core.search.data.datasource.SearchDataSource
import com.org.sweather.core.search.data.model.CityData
import com.org.sweather.core.search.domain.repository.SearchCityRepository
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

@ExperimentalCoroutinesApi
class SearchCityRepositoryImpl(
    private val searchDataSource: SearchDataSource,
    private val preferenceContract: ModelPreferenceContract
) :
    SearchCityRepository {

    //todo improve this part later
    private val isCitySaved =
        MutableStateFlow(false)

    override suspend fun getCitiesFLow(): Flow<Boolean> =
        isCitySaved

    @DelicateCoroutinesApi
    override suspend fun fetchCities(query: String) {

        isCitySaved.value = searchDataSource.getCities(query = query).fold({
            false
        }, { cityDataModel ->
            if (cityDataModel.listCities.isNotEmpty()) {
                saveCity(cityData = cityDataModel.listCities[0])
            }
            true
        })
    }

    private fun saveCity(cityData: CityData) {
        preferenceContract.put(cityData, ModelPreferenceContract.KEY_CITY)
    }
}