package com.org.sweather.settings

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.ProvideWindowInsets
import com.org.sweather.settings.ui.theme.SettingsTheme
import com.org.sweather.ui.BackAppBar
import com.org.sweather.ui.design.SweatherCheckBox

class SettingsActivity : AppCompatActivity() {

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SettingsTheme() {
                ProvideWindowInsets {
                    SettingsPage()
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun SettingsPage(modifier: Modifier = Modifier) {

    val isChecked = remember { mutableStateOf(true) }

    Scaffold(content = {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                BackAppBar(title = "Search") {

                }

            }
            item {

                SweatherCheckBox(
                    text = "Enable metrics º for  current weather",
                    checked = isChecked
                ) {
                    isChecked.value = it
                }
            }
        }
    })

}