package com.org.sweather.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.org.sweather.core.search.data.model.CityStatus
import com.org.sweather.core.search.domain.usecase.CitiesStateFlow
import com.org.sweather.core.search.domain.usecase.GetCitiesUseCase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class SearchViewModel(
    private val citiesStateFlow: CitiesStateFlow,
    private val getCitiesUseCase: GetCitiesUseCase
) : ViewModel() {


    val cityStateFlow = MutableStateFlow("")

    fun fetchCities(query: String) {
        viewModelScope.launch {
            getCitiesUseCase(query)
        }
    }

    init {
        viewModelScope.launch {
            citiesStateFlow.invoke().collect { state ->
                when (state.data) {
                    is CityStatus.CityFound -> {
                        cityStateFlow.value = (state.data as CityStatus.CityFound).city
                    }
                    else -> cityStateFlow.value = ""
                }
            }
        }
    }


}