package com.radhangs.mydesignsystem.buttons

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign

@Composable
public fun MyTextButton(
    text: String,
    onButtonPressed: () -> Unit,
    modifier: Modifier = Modifier,
    textAlignment: TextAlign = TextAlign.Center,
    enabled: Boolean = true
) {
    MyButtonSurface(
        modifier = modifier
            .semantics(mergeDescendants = true) {
                role = Role.Button
            },
        onButtonPressed = onButtonPressed,
        enabled = enabled
    ) {
        Text(
            text = text,
            textAlign = textAlignment,
            // style = /* TODO add styles */
        )
    }
}