package com.org.sweather.navigation

import android.content.Context
import androidx.navigation.NavController
import com.org.sweather.navigation.search.OnSearchRouteContract
import com.org.sweather.navigation.settings.OnSettingsContract

class MainActions(
    navController: NavController,
    onSearchRouteContract: OnSearchRouteContract,
    onSettingsRouteContract: OnSettingsContract,
    context: Context,
) {
    val gotToOnSearch = {
        onSearchRouteContract.present(context)
    }

    val goToOnSetting = {
        onSettingsRouteContract.present(context)
    }
}