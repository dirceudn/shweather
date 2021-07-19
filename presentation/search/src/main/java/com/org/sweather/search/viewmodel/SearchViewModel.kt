package com.org.sweather.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.org.sweather.core.search.domain.usecase.CitiesStateFlow
import com.org.sweather.core.search.domain.usecase.GetCitiesUseCase
import io.github.aakira.napier.Napier
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class SearchViewModel(
    private val citiesStateFlow: CitiesStateFlow,
    private val getCitiesUseCase: GetCitiesUseCase
) : ViewModel() {


    val cityStateFlow = MutableStateFlow(false)
    fun fetchCities(query: String) {
        viewModelScope.launch {
            getCitiesUseCase(query)

        }
    }

    init {
        viewModelScope.launch {
            citiesStateFlow.invoke().collect {
                cityStateFlow.value = it
                Napier.d("S5 $it")
            }
        }
    }


}