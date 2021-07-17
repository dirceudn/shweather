package com.org.sweather.core.app.di

import com.org.sweather.core.home.homeModules
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration


fun initKoin(
    openWeatherBaseUrl: String,
    isDebug: Boolean,
    openWeatherAppId: String,
    specificModules: List<Module>,
    appDeclaration: KoinAppDeclaration = {},
) = startKoin {
    appDeclaration()
    modules(
        homeModules(openWeatherBaseUrl, openWeatherAppId) + specificModules
    )

}