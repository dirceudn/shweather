package com.org.sweather.core.settings.data.repository

import com.org.sweather.core.ModelPreferenceContract
import com.org.sweather.core.settings.domain.SettingsRepository

class SettingsRepositoryImpl(private val preferenceContract: ModelPreferenceContract) :
    SettingsRepository {

    override fun enableMetrics(enable: Boolean) {
        preferenceContract.enableMetric(enable = enable, ModelPreferenceContract.ENABLE_METRIC)
    }

    override fun isMetricEnabled(): Boolean = preferenceContract.isMetricEnable()
}