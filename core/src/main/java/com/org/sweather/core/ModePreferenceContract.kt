package com.org.sweather.core

import com.org.sweather.core.search.data.model.CityData

interface ModelPreferenceContract {
    fun <T> put(`object`: T, key: String)
    fun get(key: String): CityData?

    companion object {
        const val KEY_CITY = "KEY_CITY"
    }
}