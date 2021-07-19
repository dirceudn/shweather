package com.org.sweather.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.org.sweather.search.ui.theme.transparent
import com.org.sweather.ui.design.SearchOutlineField

@Composable
fun SearchScreenPage(
    cityValue: State<String>,
    onCityNameChanged: (String) -> Unit
) {

    val focusRequester = remember { FocusRequester() }

    Spacer(
        Modifier
            .background(transparent)
            .height(24.dp) // Match the height of the status bar
            .fillMaxWidth()
    )
    SearchOutlineField(
        modifier = Modifier.focusRequester(focusRequester),
        trailingIcon = {

        },
        onTrailingIconClicked = {

        },
        placeholder = "Search your city by name",
        value = cityValue.value,
        onValueChange = { onCityNameChanged(it) },
        onImeActionPerformed = { action ->
            if (action == ImeAction.Next) {
                focusRequester.requestFocus()
                // do something here
            }
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next, // ** Go to next **
        )
    )
}