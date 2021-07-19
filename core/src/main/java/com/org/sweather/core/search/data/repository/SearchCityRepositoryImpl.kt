package com.org.sweather.core.search.data.repository

import com.org.sweather.core.common.State
import com.org.sweather.core.search.data.datasource.SearchDataSource
import com.org.sweather.core.search.data.model.CityDataModel
import com.org.sweather.core.search.domain.repository.SearchCityRepository
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class SearchCityRepositoryImpl(private val searchDataSource: SearchDataSource) :
    SearchCityRepository {


    private val citiesDataMutableStateFlow =
        MutableStateFlow<State<CityDataModel>>(State.Uninitialized(CityDataModel()))

    override suspend fun getCitiesFLow(): Flow<State<CityDataModel>> =
        citiesDataMutableStateFlow

    @DelicateCoroutinesApi
    override suspend fun fetchCities() {

        citiesDataMutableStateFlow.value = searchDataSource.getCities().fold({
            State.Failure(data = citiesDataMutableStateFlow.value())
        }, { cityDataModel ->
            State.Success(cityDataModel)
        })
    }
}