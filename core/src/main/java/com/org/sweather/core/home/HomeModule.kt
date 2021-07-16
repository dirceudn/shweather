package com.org.sweather.core.home

import com.org.sweather.core.clients.openWeatherClientFactory
import com.org.sweather.core.home.api.network.OpenWeatherApi
import org.koin.dsl.module

fun homeModule(openWeatherBaseUrl: String, openWeatherAppId: String) = module {
    single<OpenWeatherApi> {
        OpenWeatherApi {
            openWeatherClientFactory(
                openWeatherAppId,
                openWeatherBaseUrl,
                isDebug = true
            )
        }
    }
}