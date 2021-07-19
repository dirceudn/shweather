package com.org.sweather.search.model

import com.org.sweather.core.search.data.model.CityData

data class CityUIModel(val cities: List<CitiEntity>)

data class CitiEntity(
    val id: String,
    val name: String,
    val lat: Double,
    val lng: Double
)


fun CityData.toEntity() = CitiEntity(
    id = id,
    name = city,
    lat = lat,
    lng = lng
)