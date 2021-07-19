package com.org.sweather.core.search.data.model

import com.org.sweather.core.search.api.model.NetworkCityDataModel
import java.util.*

data class CityDataModel(
    val listCities: List<CityData> = emptyList()
)

data class CityData(
    val city: String,
    val iso2: String,
    val adminName: String,
    val capital: String,
    val lat: Double,
    val lng: Double,
    val country: String,
    val population: String,
    val populationPro: String,
    val id: String = uuIdGenerate(),
) {
    companion object {
        private const val prefix = "ci"

        private fun uuIdGenerate() = prefix + UUID.randomUUID().toString()
    }
}


fun NetworkCityDataModel.toDataModel() = CityData(
    city = city,
    lat = lat.toDouble(),
    lng = lng.toDouble(),
    country = country,
    iso2 = iso2,
    adminName = adminName,
    capital = capital,
    population = population,
    populationPro = propulationProper
)