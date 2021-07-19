package com.org.sweather.ui

import androidx.annotation.DrawableRes

sealed class MenuAction(
    @DrawableRes val icon: Int
) {

    object Search : MenuAction(R.drawable.ic_baseline_search_24)
    object Settings : MenuAction(R.drawable.ic_baseline_settings_24)
}