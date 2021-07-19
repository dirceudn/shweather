package com.org.sweather.core.search.api.network

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class SearchCityApi(private val clientFactory: () -> HttpClient) {

    val client by lazy {
        clientFactory()
    }

    suspend fun fetchCities(cityQuery: String) = client.get<HttpResponse> {
        url {
            encodedPath = "/api/location/search"
            parameters.append("query", cityQuery)
        }
    }
}