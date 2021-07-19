package com.org.sweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.ProvideWindowInsets
import com.org.sweather.home.screen.HomeScreen
import com.org.sweather.home.viewmodel.HomeViewModel
import com.org.sweather.navigation.RoutePageScreen
import com.org.sweather.navigation.search.OnSearchRouteContract
import com.org.sweather.ui.SweatherAppBar
import com.org.sweather.ui.theme.SweatherTheme
import com.org.sweather.ui.warmFlameEnd
import com.org.sweather.ui.warmFlameStart
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    @InternalCoroutinesApi
    private val homeViewModel: HomeViewModel by viewModel()
    private val onSearchRouteContract: OnSearchRouteContract by inject()


    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SweatherTheme {
                val context = LocalContext.current
                ProvideWindowInsets {
                    RoutePageScreen(
                        homeViewModel = homeViewModel,
                        context = context,
                        onSearchRouteContract = onSearchRouteContract
                    )
                }
            }
        }
    }

    @InternalCoroutinesApi
    override fun onResume() {
        super.onResume()
        homeViewModel.fetchWeather()
    }
}

@Preview(showBackground = true)
@InternalCoroutinesApi
@Composable
fun MainPage(
    homeViewModel: HomeViewModel,
    onSearchSelected: () -> Unit,
    onSettingSelected: () -> Unit
) {
    Box(
        Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        warmFlameStart,
                        warmFlameEnd
                    )
                )
            )
            .fillMaxSize()
    ) {

        Column() {
            SweatherAppBar(
                onSearchSelected = onSearchSelected,
                onSettingSelected = onSettingSelected
            )
            HomeScreen(homeViewMode = homeViewModel)
        }
    }
}

