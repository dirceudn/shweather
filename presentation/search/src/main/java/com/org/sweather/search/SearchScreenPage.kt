package com.org.sweather.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.org.sweather.search.ui.theme.transparent
import com.org.sweather.search.viewmodel.SearchViewModel
import com.org.sweather.ui.design.SearchOutlineField
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@Composable
fun SearchScreenPage(
    searchViewModel: SearchViewModel,
    cityValue: State<String>,
    showOnBack: () -> Unit,
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
            Image(
                modifier = Modifier
                    .size(48.dp)
                    .padding(10.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.search__1_),
                contentDescription = "information button",
                colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.LightGray)

            )
        },
        onTrailingIconClicked = {
            if (cityValue.value.isNotEmpty()) {
                searchViewModel.fetchCities(query = cityValue.value)
                showOnBack()
            }
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
            imeAction = ImeAction.Done, // ** Go to next **
        )
    )
}