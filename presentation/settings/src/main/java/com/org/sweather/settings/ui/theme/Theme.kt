package com.org.sweather.settings.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.org.sweather.ui.transparent
import com.org.sweather.ui.warmFlameStart


@Composable
fun SettingsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    color: Color? = null,
    content: @Composable() () -> Unit,

) {
    val colors = if (darkTheme) {
//        DarkColorPalette.copy(
//            primary = color ?: DarkColorPalette.primary,
//            secondary = color ?: DarkColorPalette.secondary,
//            surface = color ?: DarkColorPalette.surface,
//            primaryVariant = color ?: DarkColorPalette.primaryVariant,
//        )
        LightColorPalette.copy(
            primary = color ?: LightColorPalette.primary,
            secondary = color ?: LightColorPalette.secondary,
            surface = color ?: LightColorPalette.surface,
            primaryVariant = color ?: LightColorPalette.primaryVariant,
        )
    } else {
        LightColorPalette.copy(
            primary = color ?: LightColorPalette.primary,
            secondary = color ?: LightColorPalette.secondary,
            surface = color ?: LightColorPalette.surface,
            primaryVariant = color ?: LightColorPalette.primaryVariant,
        )
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}