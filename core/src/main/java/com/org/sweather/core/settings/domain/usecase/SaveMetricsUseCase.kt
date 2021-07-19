package com.org.sweather.core.settings.domain.usecase

import com.org.sweather.core.settings.domain.SettingsRepository

interface SaveMetricsUseCase {
    operator fun invoke(enable: Boolean)
}

fun saveMetricsUseCase(repository: SettingsRepository): SaveMetricsUseCase =
    object : SaveMetricsUseCase {
        override fun invoke(enable: Boolean) =
            repository.enableMetrics(enable = enable)
    }
