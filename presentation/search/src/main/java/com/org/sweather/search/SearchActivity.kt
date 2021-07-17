package com.org.sweather.search

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.ProvideWindowInsets
import com.org.sweather.search.ui.theme.SearchTheme

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchTheme {
                ProvideWindowInsets {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Search $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SearchTheme {
        Greeting("Android")
    }
}