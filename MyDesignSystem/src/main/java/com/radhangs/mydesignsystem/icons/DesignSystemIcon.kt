package com.radhangs.mydesignsystem.icons

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.radhangs.mydesignsystem.R

public sealed class DesignSystemIcon(@DrawableRes public val resourceId: Int) {
    @Composable
    public fun toIcon(
        contentDescription: String,
        modifier: Modifier = Modifier
    ) {

    }
}

public object DesignSystemIcons {
    public data object Search : DesignSystemIcon(R.drawable.ic_search)
}