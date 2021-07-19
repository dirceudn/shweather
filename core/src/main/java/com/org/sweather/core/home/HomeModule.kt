package com.org.sweather.core.home

import com.org.sweather.core.clients.openWeatherClientFactory
import com.org.sweather.core.home.api.network.NetworkWeatherDataSource
import com.org.sweather.core.home.api.network.OpenWeatherApi
import com.org.sweather.core.home.data.datasource.WeatherDataSource
import com.org.sweather.core.home.data.repository.CitySavedRepositoryImpl
import com.org.sweather.core.home.data.repository.WeatherRepositoryImpl
import com.org.sweather.core.home.domain.repository.CitySavedRepository
import com.org.sweather.core.home.domain.repository.WeatherRepository
import com.org.sweather.core.home.domain.usecase.*
import org.koin.dsl.module

fun homeDiModule(openWeatherBaseUrl: String, openWeatherAppId: String) = module {
    single<OpenWeatherApi> {
        OpenWeatherApi {
            openWeatherClientFactory(
                openWeatherAppId,
                openWeatherBaseUrl,
                isDebug = true
            )
        }
    }

    single<WeatherDataSource> { NetworkWeatherDataSource(get(), get()) }
}

val useCase = module {
    factory<WeatherStateFlow> { getWeatherFlow(get()) }
    factory<GetWeatherUsecase> { getWeatherUseCase(get()) }
    factory<GetCitySavedUseCase> { getCitySavedUseCase(get()) }
}

val weatherRepositoryModule = module {
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }
    single<CitySavedRepository> { CitySavedRepositoryImpl(get()) }
}

fun homeModules(openWeatherBaseUrl: String, openWeatherAppId: String) =
    homeDiModule(openWeatherBaseUrl, openWeatherAppId) + useCase + weatherRepositoryModule