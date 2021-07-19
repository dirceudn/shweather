package com.org.sweather.core.search.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCityDataModel(
    @SerialName("woeid")
    val id: String,
    @SerialName("title")
    val cityTitle: String,
    @SerialName("location_type")
    val locationType: String,
    @SerialName("latt_long")
    val latLng: String,
)

