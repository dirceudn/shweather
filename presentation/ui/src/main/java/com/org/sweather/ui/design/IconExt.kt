package com.org.sweather.ui.design

import com.org.sweather.ui.R


fun String.parserIconDrawable(): Int {
    return when (this) {
        "01d" -> R.drawable.wi_day_sunny
        "02d" -> R.drawable.wi_cloudy
        "03d" -> R.drawable.wi_cloud
        "04d" -> R.drawable.wi_cloud_down
        "09d" -> R.drawable.wi_day_rain
        "10d" -> R.drawable.wi_day_rain_mix
        "11d" -> R.drawable.wi_day_thunderstorm
        "13d" -> R.drawable.wi_day_snow
        "50d" -> R.drawable.wi_snow_wind
        "01n" -> R.drawable.wi_night_clear
        "02n" -> R.drawable.wi_night_alt_cloudy
        "03n" -> R.drawable.wi_night_cloudy
        "04n" -> R.drawable.wi_night_partly_cloudy
        "09n" -> R.drawable.wi_night_thunderstorm
        "10n" -> R.drawable.wi_night_rain
        "11n" -> R.drawable.wi_night_snow
        "13n" -> R.drawable.wi_night_showers
        "50n" -> R.drawable.wi_night_snow_thunderstorm
        else -> R.drawable.wi_umbrella
    }
}
