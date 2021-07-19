package com.org.sweather.app.di

import com.org.sweather.home.viewmodel.HomeViewModel
import com.org.sweather.navigation.search.OnSearchRoute
import com.org.sweather.navigation.search.OnSearchRouteContract
import com.org.sweather.navigation.settings.OnSettingsContract
import com.org.sweather.navigation.settings.OnSettingsRoute
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


@InternalCoroutinesApi
val appModule = module {

    viewModel { HomeViewModel(get(), get(), get()) }

    factory<OnSearchRouteContract> { OnSearchRoute() }
    factory<OnSettingsContract> { OnSettingsRoute() }

}
