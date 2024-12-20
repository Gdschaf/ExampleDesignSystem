package com.radhangs.mydesignsystem.util

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF, // White for light mode
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Light Mode"
)
internal annotation class LightModePreview

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111111, // Dark gray for dark mode
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
internal annotation class DarkModePreview