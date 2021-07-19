package com.org.sweather.ui.design

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.org.sweather.ui.grey
import com.org.sweather.ui.lightGrey
import com.org.sweather.ui.thme.font
import com.org.sweather.ui.warmFlameStart

@ExperimentalMaterialApi
@Composable
fun SweatherCheckBox(
    text: String,
    checked: State<Boolean>,
    loading: Boolean = false,
    onCheckedChanged: (Boolean) -> Unit
) {
    Column(modifier = Modifier.clickable {
        onCheckedChanged(checked.value)
    }) {
        ESightVerticalMediumSpacer()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(0.9f), text = text,
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontFamily = font,
                    fontWeight = FontWeight.Medium
                )
            )
            if (loading) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier.size(24.dp),
                    ) {
                        EsightLoader(color = warmFlameStart)
                    }
                }
            } else {
                Switch(
                    modifier = Modifier.fillMaxWidth(),
                    checked = checked.value,
                    colors = checkBoxColors(),
                    onCheckedChange = onCheckedChanged
                )
            }
        }
        ESightVerticalMediumSpacer()
    }
}

@ExperimentalMaterialApi
@Composable
fun checkBoxColors(
    checkedTrackColor: Color = warmFlameStart.copy(alpha = 0.5f),
    uncheckedTrackColor: Color = lightGrey,
    uncheckedThumbColor: Color = grey,
    checkedThumbColor: Color = warmFlameStart,
): SwitchColors = object : SwitchColors {
    @Composable
    override fun thumbColor(enabled: Boolean, checked: Boolean): State<Color> =
        mutableStateOf(
            if (enabled) {
                if (checked) checkedThumbColor else uncheckedThumbColor
            } else {
                if (checked) checkedThumbColor.copy(alpha = 0.5f) else uncheckedThumbColor.copy(
                    alpha = 0.5f
                )
            }
        )


    @Composable
    override fun trackColor(enabled: Boolean, checked: Boolean): State<Color> =
        mutableStateOf(
            if (enabled) {
                if (checked) checkedTrackColor else uncheckedTrackColor
            } else {
                if (checked) checkedTrackColor.copy(alpha = 0.5f) else uncheckedTrackColor.copy(
                    alpha = 0.5f
                )
            }
        )

}

@Composable
fun ESightVerticalMediumSpacer() {
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun EsightLoader(color: Color? = null, width: Dp = 4.dp) = CircularProgressIndicator(
    color = color ?: MaterialTheme.colors.primary,
    strokeWidth = width,
)