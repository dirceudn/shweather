package com.org.sweather.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.org.sweather.core.common.State
import com.org.sweather.core.search.domain.usecase.CitiesStateFlow
import com.org.sweather.core.search.domain.usecase.GetCitiesUseCase
import com.org.sweather.search.model.CityUIModel
import com.org.sweather.search.model.toEntity
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class SearchViewModel(
    private val citiesStateFlow: CitiesStateFlow,
    private val getCitiesUseCase: GetCitiesUseCase
) : ViewModel() {

    fun fetchCities() {
        viewModelScope.launch {
            getCitiesUseCase.invoke()
        }
    }

    val citiesUiStateFlow = MutableStateFlow<CityUIModel?>(null)

    init {

        viewModelScope.launch {
            citiesStateFlow.invoke().collect { state ->
                when (state) {
                    is State.Uninitialized -> {citiesUiStateFlow.value =
                        null}
                    is State.Loading -> {citiesUiStateFlow.value =
                        null}
                    is State.Failure -> {citiesUiStateFlow.value =
                        null}
                    is State.Success -> {citiesUiStateFlow.value =
                        state()?.listCities?.map { it.toEntity() }?.let { CityUIModel(cities = it) }}
                }

            }
        }

    }
}