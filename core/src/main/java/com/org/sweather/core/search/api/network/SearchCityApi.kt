package com.org.sweather.core.search.api.network

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class SearchCityApi(private val clientFactory: () -> HttpClient) {

    val client by lazy {
        clientFactory()
    }

    suspend fun fetchCities() = client.get<HttpResponse> {
        url {
            encodedPath = "/france"
        }
    }
}