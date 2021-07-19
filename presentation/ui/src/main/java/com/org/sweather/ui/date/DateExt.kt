package com.org.sweather.ui.date

import java.text.SimpleDateFormat
import java.util.*

fun Long.getDateTime(): String? {
    val timeStamp = this
    return try {
        val sdf = SimpleDateFormat("EEEE dd MMMM", Locale.getDefault())
        val netDate = Date(timeStamp * 1000)
        sdf.format(netDate)
    } catch (e: Exception) {
        "--"
    }
}

fun Long.getDayOfWeek(): String? {
    val timeStamp = this
    return try {
        val sdf = SimpleDateFormat("EEE", Locale.getDefault())
        val netDate = Date(timeStamp * 1000)
        sdf.format(netDate)
    } catch (e: Exception) {
        "--"
    }
}