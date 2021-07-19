package com.org.sweather.search

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.PopupProperties
import androidx.lifecycle.asLiveData
import com.google.accompanist.insets.ProvideWindowInsets
import com.org.sweather.search.ui.theme.SearchTheme
import com.org.sweather.search.viewmodel.SearchViewModel
import io.github.aakira.napier.Napier
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
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
                    Surface(color = Color.Cyan,modifier =  Modifier.fillMaxSize()){
                        AutoCompleteText(searchViewModel = searchViewModel, onValueChange = {
                            Napier.d("VALUE $it")


                        }, onOptionSelected = {

                        })
                    }
                }
            }
        }
    }

    @InternalCoroutinesApi
    override fun onResume() {
        super.onResume()
        searchViewModel.fetchCities()

    }
}


@InternalCoroutinesApi
@Composable
fun AutoCompleteText(
    searchViewModel: SearchViewModel,
    onValueChange: (String) -> Unit,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: @Composable (() -> Unit)? = null,
    suggestions: List<String> = emptyList()
) {

    val search = searchViewModel.citiesUiStateFlow.collectAsState()
    Napier.d("CITTY ${search.value}")

    Column(modifier = modifier) {
        val citySearchMutableState = mutableStateOf("")
        val listFilter = remember { mutableStateOf(emptyList<String>()) }
        val list = listOf("aaaa", "bbbbb", "cccc")

        SearchScreenPage(cityValue = citySearchMutableState) {
            citySearchMutableState.value = it
            listFilter.value =
                list.filter { item ->
                    item.startsWith(
                        citySearchMutableState.value,
                        ignoreCase = true
                    )
                }
            Napier.d("CHANGED $it")
            Napier.d("CHANGED1 $listFilter")

        }
        DropdownMenu(
            expanded = suggestions.isNotEmpty(),
            onDismissRequest = { },
            modifier = Modifier.fillMaxWidth(),
            // This line here will accomplish what you want
            properties = PopupProperties(focusable = false)
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    onOptionSelected(label)
                }) {
                    Text(text = label)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SearchTheme {
        // Greeting("Android")
    }
}