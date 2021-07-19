package com.org.sweather.core.home.api.network

import com.org.sweather.core.LanguageManager
import com.org.sweather.core.ModelPreferenceContract
import com.org.sweather.core.common.launchRequest
import com.org.sweather.core.home.api.model.WeatherNetworkModel
import com.org.sweather.core.home.data.datasource.WeatherDataSource
import com.org.sweather.core.home.data.model.toDataModel
import com.org.sweather.core.search.data.model.CityData

class NetworkWeatherDataSource(
    private val openWeatherApi: OpenWeatherApi,
    private val languageManager: LanguageManager,
    private val preferenceContract: ModelPreferenceContract
) : WeatherDataSource {

    override suspend fun getWeather(cityData: CityData) = launchRequest<WeatherNetworkModel> {
        request = {
            openWeatherApi.fetchWeather(
                unit = if (preferenceContract.isMetricEnable()) "metric" else "imperial",
                lat = cityData.lat,
                lng = cityData.lng,
                language = languageManager.getLanguage()
            )
        }
    }.map {
        it.toDataModel(city = cityData.city)
    }

}