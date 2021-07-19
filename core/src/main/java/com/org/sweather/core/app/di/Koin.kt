package com.org.sweather.core.app.di

import com.org.sweather.core.LanguageManager
import com.org.sweather.core.ModelPreferenceContract
import com.org.sweather.core.home.homeModules
import com.org.sweather.core.search.searchCityModule
import com.org.sweather.core.settings.settingsModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module


@ExperimentalCoroutinesApi
fun initKoin(
    openWeatherBaseUrl: String,
    searchCityBaseUrl: String,
    isDebug: Boolean,
    openWeatherAppId: String,
    languageManager: LanguageManager,
    preferenceManager: ModelPreferenceContract,
    specificModules: List<Module>,
    appDeclaration: KoinAppDeclaration = {},
) = startKoin {
    appDeclaration()
    modules(
        homeModules(openWeatherBaseUrl, openWeatherAppId) + searchCityModule(
            searchCityBaseUrl,
            isDebug
        ) + settingsModule() + specificModules + module {
            single { languageManager }
        } + module { single { preferenceManager } }
    )

}