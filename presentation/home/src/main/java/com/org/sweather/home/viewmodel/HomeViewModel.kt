package com.org.sweather.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.org.sweather.core.common.State
import com.org.sweather.core.home.domain.usecase.GetCitySavedUseCase
import com.org.sweather.core.home.domain.usecase.GetWeatherUsecase
import com.org.sweather.core.home.domain.usecase.WeatherStateFlow
import com.org.sweather.home.model.EmptyWeather
import com.org.sweather.home.model.WeatherUiModel
import com.org.sweather.home.model.toUiModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class HomeViewModel(
    private val weatherStateFlow: WeatherStateFlow,
    private val getWeatherUseCase: GetWeatherUsecase,
    private val getCitySavedUseCase: GetCitySavedUseCase
) : ViewModel() {

    fun fetchWeather() {
        viewModelScope.launch {
            val city = getCitySavedUseCase.invoke()
            getWeatherUseCase.invoke(cityData = city)
        }
    }

    val weatherUiStateFlow = MutableStateFlow<WeatherUiModel?>(
        EmptyWeather()
    )

    init {
        viewModelScope.launch {
            weatherStateFlow.invoke().collect { state ->
                when (state) {
                    is State.Uninitialized -> weatherUiStateFlow.value = EmptyWeather()
                    is State.Loading -> weatherUiStateFlow.value = EmptyWeather()
                    is State.Success -> weatherUiStateFlow.value = state()?.toUiModel()
                    is State.Failure -> weatherUiStateFlow.value = EmptyWeather()

                    else -> weatherUiStateFlow.value = EmptyWeather()
                }
            }
        }
    }

}

