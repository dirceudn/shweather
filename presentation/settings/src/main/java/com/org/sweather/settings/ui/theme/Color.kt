package com.org.sweather.settings.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val salem = Color(0xFF00A82D)
val teal200 = Color(0xFF03DAC5)
val funGreen = Color(0xFF008D2D)
val lunarGreen = Color(0xFF373A36)
val red = Color(0xFFFF0000)
val redOrange = Color(0xFFFF3B30)
val jumbo = Color(0xFF8A8A8F)
val boulder = Color(0xFF7D7D7D)
val mineShaft = Color(0xFF2A2A2A)
val manatee = Color(0xFF9A99A2)
val malachite = Color(0xFF0ABA66)

val black = Color(0xFF000000)
val white = Color(0xFFFFFFFF)
val transparent = Color(0x00000000)
val blackTransparency = Color(0xaa000000)
val blackLessTransparency = Color(0xdd000000)
val blackBlurry = Color(0x55000000)

val grey = Color(0xFF838383)
val lightGrey = Color(0xFFd7d7d7)


val lowAvailabilityColor = Color(0xFFFF8C00)
val highAvailabilityColor = Color(0xFF008000)

val buttonBackground = lunarGreen
val disabledButtonBackground = lunarGreen.copy(alpha = 0.5f)

val textErrorColor = red

val DarkColorPalette = darkColors(
    primary = salem,
    surface = salem,
    primaryVariant = salem,
    secondary = teal200,
)

val LightColorPalette = lightColors(
    primary = salem,
    surface = salem,
    primaryVariant = salem,
    secondary = teal200,
)
