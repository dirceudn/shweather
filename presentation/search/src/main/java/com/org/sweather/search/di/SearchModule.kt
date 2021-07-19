package com.org.sweather.search.di

import com.org.sweather.search.viewmodel.SearchViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@InternalCoroutinesApi
val searchModule = module {
    viewModel { SearchViewModel(get(), get()) }
}