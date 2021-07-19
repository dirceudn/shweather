package com.org.sweather.core.search.api.network

import com.org.sweather.core.common.launchRequest
import com.org.sweather.core.search.api.model.NetworkCityResponse
import com.org.sweather.core.search.data.datasource.SearchDataSource
import com.org.sweather.core.search.data.model.CityDataModel
import com.org.sweather.core.search.data.model.toDataModel

class NetworkSearchCityDataSource(private val cityApi: SearchCityApi) : SearchDataSource {
    override suspend fun getCities() = launchRequest<NetworkCityResponse> {
        request = {
            cityApi.fetchCities()
        }
    }.map { response ->
        CityDataModel(listCities = response.list.map { it.toDataModel() })
    }
}