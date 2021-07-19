package com.org.sweather.core.search.data.repository

import com.org.sweather.core.common.State
import com.org.sweather.core.common.debounce
import com.org.sweather.core.search.data.datasource.SearchDataSource
import com.org.sweather.core.search.data.model.CityDataModel
import com.org.sweather.core.search.domain.repository.SearchCityRepository
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class SearchCityRepositoryImpl(private val searchDataSource: SearchDataSource) :
    SearchCityRepository {


    private val citiesDataMutableStateFlow = MutableStateFlow<State<CityDataModel>>(
        State.Uninitialized(
            null
        )
    )

    override suspend fun getCitiesFLow(): Flow<State<CityDataModel>> =
        citiesDataMutableStateFlow

    @DelicateCoroutinesApi
    override suspend fun fetchCities() {

        debounce(
            waitMs = 300L,
            scope = GlobalScope
        ) {

            if (citiesDataMutableStateFlow.value !is State.Loading) {
                citiesDataMutableStateFlow.value = State.Loading(null)
                citiesDataMutableStateFlow.value = searchDataSource.getCities().fold({
                    State.Failure(data = citiesDataMutableStateFlow.value())
                }, { listOfCities ->
                    State.Success(CityDataModel(listCities = listOfCities))
                })
            }
        }


    }
}