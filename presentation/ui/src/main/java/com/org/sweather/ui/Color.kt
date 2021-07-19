package com.org.sweather.ui

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val transparent = Color(0x00000000)

val warmFlameStart = Color(0xfFff9a9e)
val grey = Color(0xFF838383)
val lightGrey = Color(0xFFd7d7d7)


val warmFlameEnd = Color(0xfffad0c4)

val gradientDay = Brush.horizontalGradient(listOf(Color(0xfFff9a9e), Color(0xfffad0c4)))
val gradientNight = Brush.horizontalGradient(listOf(Color(0xff1e3c72), Color(0xff2a5298)))