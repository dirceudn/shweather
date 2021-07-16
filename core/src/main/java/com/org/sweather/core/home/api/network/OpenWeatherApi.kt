package com.org.sweather.core.home.api.network

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*


class OpenWeatherApi(private val clientFactory: () -> HttpClient) {

    val client by lazy {
        clientFactory()
    }

    suspend fun fetchWeather(unit: String, lat: Double, lng: Double) = client.get<HttpResponse> {
        url {
            encodedPath = "/data/2.5/onecall"
            parameters.append("unit", unit)
            parameters.append("lat", lat.toString())
            parameters.append("lng", lng.toString())
        }
    }

}