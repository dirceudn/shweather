package com.org.sweather.core.home.api.network

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*


class OpenWeatherApi(private val clientFactory: () -> HttpClient) {

    val client by lazy {
        clientFactory()
    }

    suspend fun fetchWeather(unit: String, lat: String, lng: String, language: String) =
        client.get<HttpResponse> {
            url {
                encodedPath = "/data/2.5/onecall"
                parameters.append("units", unit)
                parameters.append("lat", lat)
                parameters.append("lon", lng)
                parameters.append("lang", language)
                parameters.append("exclude", "hourly,minutely")
            }
        }
}