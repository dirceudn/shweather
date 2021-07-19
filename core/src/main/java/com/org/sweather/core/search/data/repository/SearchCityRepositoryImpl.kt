package com.org.sweather.core.search.data.repository

import com.org.sweather.core.ModelPreferenceContract
import com.org.sweather.core.common.State
import com.org.sweather.core.search.data.datasource.SearchDataSource
import com.org.sweather.core.search.data.model.CityData
import com.org.sweather.core.search.data.model.CityStatus
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

    private val cityMutableStateFlow =
        MutableStateFlow<State<CityStatus>>(State.Uninitialized(CityStatus.CityNotFound))

    override suspend fun getCitiesFLow(): Flow<State<CityStatus>> =
        cityMutableStateFlow

    @DelicateCoroutinesApi
    override suspend fun fetchCities(query: String) {

        if (cityMutableStateFlow.value !is State.Loading) {
            cityMutableStateFlow.value = State.Loading(CityStatus.CitySearching)
            cityMutableStateFlow.value =
                searchDataSource.getCities(query = query).fold({
                    State.Failure(data = cityMutableStateFlow.value())
                }, { cityDataModel ->
                    if (cityDataModel.listCities.isNotEmpty()) {
                        saveCity(cityData = cityDataModel.listCities[0])
                        State.Success(data = CityStatus.CityFound(cityDataModel.listCities[0].city))
                    } else {
                        State.Failure(data = cityMutableStateFlow.value())
                    }
                })
        }
    }


    private fun saveCity(cityData: CityData) {
        preferenceContract.put(cityData, ModelPreferenceContract.KEY_CITY)
    }
}
