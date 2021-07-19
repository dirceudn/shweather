package com.org.sweather.core.search.api.network

import com.org.sweather.core.common.launchRequest
import com.org.sweather.core.search.api.model.NetworkCityDataModel
import com.org.sweather.core.search.data.datasource.SearchDataSource
import com.org.sweather.core.search.data.model.toDataModel

class NetworkSearchCityDataSource(private val cityApi: SearchCityApi) : SearchDataSource {
    override suspend fun getCities() = launchRequest<List<NetworkCityDataModel>> {
        request = {
            cityApi.fetchCities()
        }
    }.map { listCities ->
        listCities.map { it.toDataModel() }
    }
}