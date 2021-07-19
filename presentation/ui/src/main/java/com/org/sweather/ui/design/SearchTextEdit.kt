package com.org.sweather.ui.design

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.org.sweather.ui.grey
import com.org.sweather.ui.lightGrey
import com.org.sweather.ui.transparent


@Composable
fun SearchOutlineField(
    modifier: Modifier = Modifier,
    paddingLeadingIconEnd: Dp = 8.dp,
    paddingTrailingIconStart: Dp = 8.dp,
    leadingIcon: @Composable() (() -> Unit)? = null,
    trailingIcon: @Composable() (() -> Unit)? = null,
    onTrailingIconClicked: (() -> Unit)? = null,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    onImeActionPerformed: ((ImeAction) -> Unit)? = null,
    keyboardOptions: KeyboardOptions? = null
) {

    Row(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .background(
                color = transparent,
                shape = CircleShape
            )
            .border(
                width = 1.dp,
                color = lightGrey,
                shape = CircleShape,
            )
            .padding(horizontal = 16.dp)
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (leadingIcon != null) {
            leadingIcon()
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(
                    start = leadingIcon?.let { paddingLeadingIconEnd } ?: 0.dp,
                    end = trailingIcon?.let { paddingTrailingIconStart } ?: 0.dp,
                )
        ) {
            BasicTextField(
                modifier = Modifier.fillMaxWidth(),
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                keyboardActions = KeyboardActions(onDone = {
                    onImeActionPerformed?.invoke(ImeAction.Done)
                }, onNext = {
                    onImeActionPerformed?.invoke(ImeAction.Next)
                }),
                keyboardOptions = keyboardOptions ?: KeyboardOptions(),
            )
            if (value.isEmpty()) {
                Text(placeholder, style = MaterialTheme.typography.body2, color = grey)
            }
        }
        if (trailingIcon != null) {
            Box(modifier = Modifier
                .clip(shape = CircleShape)
                .clickable {
                    onTrailingIconClicked?.invoke()
                }) {
                trailingIcon()
            }
        }
    }

}