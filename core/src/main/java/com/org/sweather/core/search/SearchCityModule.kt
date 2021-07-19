package com.org.sweather.core.search

import com.org.sweather.core.clients.searchCityClientFactory
import com.org.sweather.core.search.api.network.NetworkSearchCityDataSource
import com.org.sweather.core.search.api.network.SearchCityApi
import com.org.sweather.core.search.data.datasource.SearchDataSource
import com.org.sweather.core.search.data.repository.SearchCityRepositoryImpl
import com.org.sweather.core.search.domain.repository.SearchCityRepository
import com.org.sweather.core.search.domain.usecase.CitiesStateFlow
import com.org.sweather.core.search.domain.usecase.GetCitiesUseCase
import com.org.sweather.core.search.domain.usecase.citiesStateFlow
import com.org.sweather.core.search.domain.usecase.getCitiesUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.dsl.module

fun searchCityDiModule(openSearchCityBaseUrl: String, isDebug: Boolean) = module {
    single<SearchCityApi> {
        SearchCityApi {
            searchCityClientFactory(
                openSearchCityBaseUrl = openSearchCityBaseUrl,
                isDebug = isDebug
            )
        }
    }

    single<SearchDataSource> { NetworkSearchCityDataSource(get()) }

}

@ExperimentalCoroutinesApi
val searchCityRepositoryModule = module {
    single<SearchCityRepository> { SearchCityRepositoryImpl(get(), get()) }
}

val searchCityUseCase = module {
    factory<CitiesStateFlow> { citiesStateFlow(get()) }
    factory<GetCitiesUseCase> { getCitiesUseCase(get()) }
}


@ExperimentalCoroutinesApi
fun searchCityModule(baseUrl: String, isDebug: Boolean) =
    searchCityDiModule(baseUrl, isDebug) + searchCityUseCase + searchCityRepositoryModule

