package com.org.sweather.core.home.data.model

import com.org.sweather.core.home.api.model.*

data class WeatherDataOneCall(
    val id: String?,
    val city: String?,
    val lat: Double?,
    val lng: Double?,
    val timeZone: String?,
    val weather: WeatherData?,
    val dailyWeather: List<DailyWeatherData?>
)

data class WeatherData(
    val time: Long?,
    val sunrise: Long?,
    val sunset: Long?,
    val temperature: Double?,
    val feelsLike: Double?,
    val pressure: Int?,
    val humidity: Int?,
    val dewPoint: Double?,
    val uvi: Double?,
    val clouds: Int?,
    val visibility: Long?,
    val windSpeed: Double?,
    val windDeg: Int?,
    val weather: List<WeatherResumeData?>
)

data class WeatherResumeData(
    val id: Int?,
    val main: String?,
    val description: String?,
    val icon: String?
)

data class DailyWeatherData(
    val time: Long?,
    val sunrise: Long?,
    val sunset: Long?,
    val mooonrise: Long?,
    val moonset: Long?,
    val moonPhase: Double?,
    val temperatureResume: TemperatureResumeData?,
    val feelsLikeResume: FeelsLikeResumeData?,
    val pressure: Int?,
    val humidity: Int?,
    val dewPoint: Double?,
    val windSpeed: Double?,
    val windDeg: Double?,
    val windGust: Double?,
    val weather: List<WeatherResumeData>?,
    val clouds: Double?,
    val pop: Double?,
    val uvi: Double?
)

data class FeelsLikeResumeData(
    val day: Double?,
    val night: Double?,
    val evening: Double?,
    val morning: Double?,
)

data class TemperatureResumeData(
    val day: Double?,
    val min: Double?,
    val max: Double?,
    val night: Double?,
    val evening: Double?,
    val morning: Double?,
)

fun Weather.toWeatherData(): WeatherData = WeatherData(
    time = time,
    sunrise = sunrise,
    sunset = sunset,
    temperature = temperature,
    feelsLike = feelsLike,
    pressure = pressure,
    humidity = humidity,
    dewPoint = dewPoint,
    uvi = uvi,
    windDeg = windDeg,
    windSpeed = windSpeed,
    weather = weather.map { weatherResume -> weatherResume?.toWeatherResumeData() },
    clouds = clouds,
    visibility = visibility
)

fun WeatherResume.toWeatherResumeData(): WeatherResumeData = WeatherResumeData(
    id = id,
    main = main,
    description = description,
    icon = icon
)

fun DailyWeather.toDailyWeatherData(): DailyWeatherData = DailyWeatherData(
    time = time,
    sunrise = sunrise,
    sunset = sunset,
    mooonrise = mooonrise,
    moonset = moonset,
    moonPhase = moonPhase,
    clouds = clouds,
    temperatureResume = temperatureResume?.toTemperatureResumeData(),
    feelsLikeResume = feelsLikeResume?.toFeelsLikeData(),
    pressure = pressure,
    humidity = humidity,
    dewPoint = dewPoint,
    windSpeed = windSpeed,
    windDeg = windDeg,
    windGust = windGust,
    pop = pop,
    weather = weather?.map { it.toWeatherResumeData() },
    uvi = uvi
)

fun FeelsLikeResume.toFeelsLikeData(): FeelsLikeResumeData = FeelsLikeResumeData(
    day = day,
    night = night,
    evening = evening,
    morning = morning
)

fun TemperatureResume.toTemperatureResumeData(): TemperatureResumeData = TemperatureResumeData(
    day = day,
    min = min,
    max = max,
    night = night,
    evening = evening,
    morning = morning
)

fun WeatherNetworkModel.toDataModel(city: String): WeatherDataOneCall = WeatherDataOneCall(
    id = id,
    city = city,
    lat = lat,
    lng = lng,
    timeZone = timeZone,
    weather = weather?.toWeatherData(),
    dailyWeather = dailyWeather.map { it?.toDailyWeatherData() }

)