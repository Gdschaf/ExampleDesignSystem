package com.radhangs.mydesignsystem.buttons

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
public fun MyIconButton(
    @DrawableRes iconResource: Int,
    onButtonPressed: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    // things we want for the icon button
    // make it round with an icon in the middle
    // give it a circle background
    // give it a circle black stroke when selected
    // make it ripple when pressed
    // I don't think we need to worry about hover state tbh
    MyButtonSurface(
        modifier = modifier,
        onButtonPressed = onButtonPressed,
        enabled = enabled
    ) {
        Icon(
            painter = painterResource(iconResource),
            contentDescription = "" /* TODO */
        )
    }
}