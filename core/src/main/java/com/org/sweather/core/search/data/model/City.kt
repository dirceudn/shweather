package com.org.sweather.core.search.data.model

import com.org.sweather.core.search.api.model.NetworkCityDataModel

data class CityDataModel(
    val listCities: List<CityData>
)

data class CityData(
    val id: String,
    val city: String,
    val lat: String,
    val lng: String,
    val locationType: String
) {

}


fun NetworkCityDataModel.toDataModel() = CityData(
    city = cityTitle,
    lat = latLng.toSplit()[0],
    lng = latLng.toSplit()[1],
    id = id,
    locationType = locationType
)

fun String.toSplit(): List<String> {
    return this.split(",")
}

sealed class CityStatus {
    object CityNotFound : CityStatus()
    object CityFound : CityStatus()
    object CitySearching : CityStatus()
}