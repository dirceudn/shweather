package com.org.sweather.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsHeight

@Preview(showBackground = true)
@Composable
fun SweatherAppBar(
    title: String = "", navigateUp: (() -> Boolean)? = null, onSearchSelected: () -> Unit,
    onSettingSelected: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End
    ) {
        Spacer(
            Modifier
                .background(transparent)
                .statusBarsHeight() // Match the height of the status bar
        )
        Spacer(
            Modifier
                .background(transparent)
                .height(10.dp)
        )
        Row(
            modifier = Modifier
                .height(50.dp)
                .padding(end = 10.dp)
                .background(transparent),
            verticalAlignment = Alignment.CenterVertically
        ) {
            MenuItem(icon = R.drawable.ic_baseline_search_24, description = "Search") {
                onSearchSelected()
            }
            MenuItem(icon = R.drawable.ic_baseline_settings_24, description = "Settings") {
                onSettingSelected()
            }
        }
    }
}

@Composable
fun MenuItem(@DrawableRes icon: Int, description: String, onItemClicked: () -> Unit) {
    Box(modifier = Modifier
        .padding(8.dp)
        .size(48.dp)
        .clickable { onItemClicked() }) {
        Spacer(
            Modifier
                .background(transparent)
                .width(16.dp)
        )
        Image(
            imageVector = ImageVector.vectorResource(id = icon),
            contentDescription = description,
        )
        Spacer(
            Modifier
                .background(transparent)
                .width(8.dp)
        )
    }
}