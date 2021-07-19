package com.org.sweather.core

import com.org.sweather.core.search.data.model.CityData

interface ModelPreferenceContract {


    fun <T> put(`object`: T, key: String)
    fun get(key: String): CityData?

    fun enableMetric(enable: Boolean, key: String)

    fun isMetricEnable(): Boolean

    companion object {
        const val KEY_CITY = "KEY_CITY"
        const val ENABLE_METRIC = "ENABLE_METRIC"
    }
}