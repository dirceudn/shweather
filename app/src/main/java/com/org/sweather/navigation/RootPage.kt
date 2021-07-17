package com.org.sweather.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.org.sweather.MainPage
import com.org.sweather.home.viewmodel.HomeViewModel
import com.org.sweather.navigation.search.OnSearchRouteContract
import kotlinx.coroutines.InternalCoroutinesApi


@InternalCoroutinesApi
@Composable
fun RoutePageScreen(
    homeViewModel: HomeViewModel,
    context: Context,
    onSearchRouteContract: OnSearchRouteContract
) {
    val navController = rememberNavController()

    val actionController =
        remember(navController) {
            MainActions(
                navController = navController,
                onSearchRouteContract = onSearchRouteContract,
                context = context
            )
        }


    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            MainPage(
                homeViewModel = homeViewModel,
                onSettingSelected = {},
                onSearchSelected = actionController.gotToOnSearch
            )
        }
    }

}