package com.org.sweather.navigation

import android.content.Context
import androidx.navigation.NavController
import com.org.sweather.navigation.search.OnSearchRouteContract

class MainActions(
    navController: NavController,
    onSearchRouteContract: OnSearchRouteContract,
    context: Context,
) {
    val gotToOnSearch = {
        onSearchRouteContract.present(context)
    }
}