package com.org.sweather.core.settings.domain

interface SettingsRepository {

    fun enableMetrics(enable: Boolean)
    fun isMetricEnabled(): Boolean

}