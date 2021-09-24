package com.org.sweather.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.insets.statusBarsHeight
import com.org.sweather.ui.thme.font

@Composable
fun SweatherAppBar(
    navigateUp: (() -> Boolean)? = null, onSearchSelected: () -> Unit, onSettingSelected: () -> Unit
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
            MenuItem(icon = R.drawable.search, description = "Search") {
                onSearchSelected()
            }
            MenuItem(icon = R.drawable.setting_lines, description = "Settings") {
                onSettingSelected()
            }
        }
    }
}

@Composable
fun BackAppBar(
    title: String,
    onBackClicked: () -> Unit
) {
    Column {
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
                .background(transparent),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(
                Modifier
                    .background(transparent)
                    .width(16.dp)
            )
            Box(modifier = Modifier.clickable {
                onBackClicked()
            }) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_arrow_back_24),
                    colorFilter = ColorFilter.tint(Color.Black),
                    contentDescription = "Sweather back",
                )
            }
            Spacer(
                Modifier
                    .background(transparent)
                    .width(12.dp)
            )
            Text(
                "$title .", style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontFamily = font,
                    fontWeight = FontWeight.Medium
                )
            )
        }
    }
}


@Composable
fun MenuItem(@DrawableRes icon: Int, description: String, onItemClicked: () -> Unit) {
    Box(modifier = Modifier
        .padding(10.dp)
        .size(40.dp)
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