package com.org.sweather.settings

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.ProvideWindowInsets
import com.org.sweather.settings.ui.theme.SettingsTheme
import com.org.sweather.settings.viewmodel.SettingsViewModel
import com.org.sweather.ui.BackAppBar
import com.org.sweather.ui.design.SweatherCheckBox
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsActivity : AppCompatActivity() {

    private val settingsViewModel: SettingsViewModel by viewModel()

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SettingsTheme() {
                ProvideWindowInsets {
                    SettingsPage(
                        modifier = Modifier.fillMaxSize(),
                        settingsViewModel = settingsViewModel
                    ) {
                        finish()
                    }
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun SettingsPage(
    modifier: Modifier = Modifier,
    settingsViewModel: SettingsViewModel,
    onBack: () -> Unit
) {

    val isEnabled = settingsViewModel.isMetricEnableState.collectAsState()

    val isChecked = remember { mutableStateOf(isEnabled.value) }

    Scaffold(content = {
        LazyColumn(modifier = modifier) {
            item {
                BackAppBar(title = "Settings ") {
                    onBack()

                }
            }
            item {
                SweatherCheckBox(
                    text = "Enable metrics ºC",
                    checked = isChecked
                ) {
                    isChecked.value = it
                    settingsViewModel.saveMetrics(isChecked.value)
                }
            }
        }
    })

}