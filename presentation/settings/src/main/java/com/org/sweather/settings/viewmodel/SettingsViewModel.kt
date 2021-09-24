package com.org.sweather.settings.viewmodel

import androidx.lifecycle.ViewModel
import com.org.sweather.core.settings.domain.usecase.GetMetricsUseCase
import com.org.sweather.core.settings.domain.usecase.SaveMetricsUseCase
import kotlinx.coroutines.flow.MutableStateFlow

class SettingsViewModel(
    getMetricsUseCase: GetMetricsUseCase,
    private val saveMetricsUseCase: SaveMetricsUseCase
) : ViewModel() {

    val isMetricEnableState = MutableStateFlow(false)

    init {
        isMetricEnableState.value = getMetricsUseCase.invoke()

    }

    fun saveMetrics(enable: Boolean) {
        saveMetricsUseCase.invoke(enable = enable)
    }

}