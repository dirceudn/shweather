package com.org.sweather.core.settings.domain.usecase

import com.org.sweather.core.settings.domain.SettingsRepository

interface GetMetricsUseCase {
    operator fun invoke(): Boolean
}

fun getMetricsUseCase(repository: SettingsRepository): GetMetricsUseCase =
    object : GetMetricsUseCase {
        override fun invoke() =
            repository.isMetricEnabled()
    }
