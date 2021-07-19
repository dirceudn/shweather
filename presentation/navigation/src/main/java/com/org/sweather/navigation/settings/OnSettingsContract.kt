package com.org.sweather.navigation.settings

import android.content.Context

interface OnSettingsContract {
    fun setup(dataToPass: String)
    fun present(fromContext: Context)
}