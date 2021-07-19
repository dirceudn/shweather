package com.org.sweather.ui.design

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.org.sweather.ui.transparent

@Composable
fun DailyWeatherItem(icon: String, min: String, max: String, date: String) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .background(color = transparent),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = icon.parserIconDrawable()),
                contentDescription = "description",
                Modifier.size(34.dp)
            )
            Text(
                text = date,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = "${max}°",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(4.dp)
            )
            Spacer(
                Modifier
                    .background(transparent)
                    .height(8.dp)
            )
            Text(
                text = "${min}°",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}