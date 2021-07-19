package com.org.sweather.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.org.sweather.core.common.State
import com.org.sweather.core.search.domain.usecase.CitiesStateFlow
import com.org.sweather.core.search.domain.usecase.GetCitiesUseCase
import com.org.sweather.search.model.CityUIModel
import com.org.sweather.search.model.toEntity
import io.github.aakira.napier.Napier
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.Job
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
                Napier.d("STATE ${state.data}")
            }
        }

    }
}