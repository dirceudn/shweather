package com.org.sweather.core.search.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCityDataModel(
    @SerialName("city")
    val city: String,
    @SerialName("lat")
    val lat: String,
    @SerialName("lng")
    val lng: String,
    @SerialName("country")
    val country: String,
    @SerialName("iso2")
    val iso2: String,
    @SerialName("admin_name")
    val adminName: String,
    @SerialName("capital")
    val capital: String,
    @SerialName("population")
    val population: String,
    @SerialName("population_proper")
    val propulationProper: String
)

