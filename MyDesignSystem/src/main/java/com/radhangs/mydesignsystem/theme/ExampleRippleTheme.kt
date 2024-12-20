package com.radhangs.mydesignsystem.theme

import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.RippleConfiguration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@ReadOnlyComposable
public fun exampleRippleTheme(
    pressedAlpha: Float = 0.5f,
    focusedAlpha: Float = 0f,
    draggedAlpha: Float = 1f,
    hoveredAlpha: Float = 0f
): RippleConfiguration = RippleConfiguration(
    color = LocalContentColor.current,
    rippleAlpha = RippleAlpha(
        pressedAlpha = pressedAlpha,
        focusedAlpha = focusedAlpha,
        draggedAlpha = draggedAlpha,
        hoveredAlpha = hoveredAlpha
    )
)