package com.radhangs.mydesignsystem.icons

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.radhangs.mydesignsystem.R

public sealed class DesignSystemIcon(@DrawableRes public val resourceId: Int) {
    @Composable
    public fun ToIcon(
        contentDescription: String?,
        modifier: Modifier = Modifier,
        tint: Color = Color.Unspecified
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = resourceId),
            contentDescription = contentDescription,
            modifier = modifier,
            tint = tint
        )
    }
}

public object DesignSystemIcons {
    public data object Search : DesignSystemIcon(R.drawable.ic_search)
    public object Image {
        public data object Filled : DesignSystemIcon(R.drawable.ic_image_filled)
        public data object Outlined : DesignSystemIcon(R.drawable.ic_image_outlined)
    }
}