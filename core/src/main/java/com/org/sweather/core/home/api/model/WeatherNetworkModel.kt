package com.org.sweather.core.home.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherNetworkModel(
    val id: String? = null,
    val city: String? = null,
    @SerialName("lat")
    val lat: Double?,
    @SerialName("lon")
    val lng: Double?,
    @SerialName("timezone")
    val timeZone: String?,
    @SerialName("current")
    val weather: Weather?,
    @SerialName("daily")
    val dailyWeather: List<DailyWeather?>
)

@Serializable
data class Weather(
    @SerialName("dt")
    val time: Long?,
    @SerialName("sunrise")
    val sunrise: Long,
    @SerialName("sunset")
    val sunset: Long?,
    @SerialName("temp")
    val temperature: Double?,
    @SerialName("feels_like")
    val feelsLike: Double?,
    @SerialName("pressure")
    val pressure: Int?,
    @SerialName("humidity")
    val humidity: Int?,
    @SerialName("dew_point")
    val dewPoint: Double?,
    @SerialName("uvi")
    val uvi: Double?,
    @SerialName("clouds")
    val clouds: Int?,
    @SerialName("visibility")
    val visibility: Long?,
    @SerialName("wind_speed")
    val windSpeed: Double?,
    @SerialName("wind_deg")
    val windDeg: Int?,
    @SerialName("weather")
    val weather: List<WeatherResume?>
)

@Serializable
data class WeatherResume(
    @SerialName("id")
    val id: Int?,
    @SerialName("main")
    val main: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("icon")
    val icon: String?
)


@Serializable
data class DailyWeather(
    @SerialName("dt")
    val time: Long?,
    @SerialName("sunrise")
    val sunrise: Long?,
    @SerialName("sunset")
    val sunset: Long?,
    @SerialName("moonrise")
    val mooonrise: Long?,
    @SerialName("moonset")
    val moonset: Long?,
    @SerialName("moon_phase")
    val moonPhase: Double?,
    @SerialName("temp")
    val temperatureResume: TemperatureResume?,
    @SerialName("feels_like")
    val feelsLikeResume: FeelsLikeResume?,
    @SerialName("pressure")
    val pressure: Int?,
    @SerialName("humidity")
    val humidity: Int?,
    @SerialName("dew_point")
    val dewPoint: Double?,
    @SerialName("wind_speed")
    val windSpeed: Double?,
    @SerialName("wind_deg")
    val windDeg: Double?,
    @SerialName("wind_gust")
    val windGust: Double?,
    @SerialName("weather")
    val weather: List<WeatherResume>?,
    @SerialName("clouds")
    val clouds: Double?,
    @SerialName("pop")
    val pop: Double?,
    @SerialName("uvi")
    val uvi: Double?
)
@Serializable
data class FeelsLikeResume(
    @SerialName("day")
    val day: Double,
    @SerialName("night")
    val night: Double,
    @SerialName("eve")
    val evening: Double,
    @SerialName("morn")
    val morning: Double,
)
@Serializable
data class TemperatureResume(
    @SerialName("day")
    val day: Double,
    @SerialName("min")
    val min: Double,
    @SerialName("max")
    val max: Double,
    @SerialName("night")
    val night: Double,
    @SerialName("eve")
    val evening: Double,
    @SerialName("morn")
    val morning: Double,
)