package com.org.sweather.search

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.ProvideWindowInsets
import com.org.sweather.search.ui.theme.SearchTheme
import com.org.sweather.search.viewmodel.SearchViewModel
import com.org.sweather.ui.BackAppBar
import com.org.sweather.ui.design.SnackBarCity
import com.org.sweather.ui.extensions.hideKeyboard
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchActivity : AppCompatActivity() {
    @InternalCoroutinesApi
    private val searchViewModel: SearchViewModel by viewModel()

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchTheme() {
                ProvideWindowInsets {
                    AutoCompleteSearchCityText(
                        searchViewModel = searchViewModel,
                        onBack = {

                            finish()
                        },
                        onOptionSelected = {
                            this.hideKeyboard()
                        })
                }
            }
        }
    }

}


@InternalCoroutinesApi
@Composable
fun AutoCompleteSearchCityText(
    searchViewModel: SearchViewModel,
    onBack: () -> Unit,
    onOptionSelected: () -> Unit,
    modifier: Modifier = Modifier
) {

    val onSearchClick = remember { mutableStateOf(false) }
    val foundedCity = searchViewModel.cityStateFlow.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = modifier) {
            val citySearchMutableState = mutableStateOf("")
            BackAppBar(title = "Search") {
                onBack()
            }

            SearchScreenPage(
                cityValue = citySearchMutableState,
                searchViewModel = searchViewModel,
                showOnBack = { onSearchClick.value = true },
                onCityNameChanged = { citySearchMutableState.value = it }
            )

        }
        if (onSearchClick.value) {
            onOptionSelected()
            Box(modifier = Modifier.align(alignment = Alignment.BottomCenter)) {
                SnackBarCity(city = foundedCity.value) {
                    onBack()
                }
            }
        }
    }

}
