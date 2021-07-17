package com.org.sweather.search.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.org.sweather.ui.transparent
import com.org.sweather.ui.warmFlameStart

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = warmFlameStart,
    primaryVariant = warmFlameStart,
    secondary = warmFlameStart,
    background = warmFlameStart,
    surface = warmFlameStart,
    onPrimary = warmFlameStart,
    onSecondary = warmFlameStart,
    onBackground = warmFlameStart,
    onSurface = warmFlameStart

    /* Other default colors to override
background = Color.White,
surface = Color.White,
onPrimary = Color.White,
onSecondary = Color.Black,
onBackground = Color.Black,
onSurface = Color.Black,
*/
)

@Composable
fun SearchTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}