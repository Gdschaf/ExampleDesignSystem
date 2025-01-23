package com.radhangs.exampledesignsystem

import androidx.annotation.DrawableRes

internal data class HomeScreenItem(
    val itemTitle: String,
    @DrawableRes val previewImage: Int,
    val navigationString: String
)

internal val homeScreenItems = listOf(
    HomeScreenItem(
        itemTitle = "Text Button",
        previewImage = 0,
        navigationString = "text_button_component"
    ),
    HomeScreenItem(
        itemTitle = "Icon Button",
        previewImage = 0,
        navigationString = "icon_button_component"
    )
)