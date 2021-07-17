package com.org.sweather.navigation.search

import android.content.Context

interface OnSearchRouteContract {

    fun setup(dataToPass: String)
    fun present(fromContext: Context)
}