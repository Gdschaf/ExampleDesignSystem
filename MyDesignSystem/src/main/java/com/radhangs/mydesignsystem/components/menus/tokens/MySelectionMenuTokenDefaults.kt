package com.radhangs.mydesignsystem.components.menus.tokens

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.radhangs.mydesignsystem.theme.tokens.theme.ThemeTokensInterface

public class MySelectionMenuTokenDefaults(themeTokens: ThemeTokensInterface) {
    public var menuTokenDefaults: MyMenuTokenDefaults = MyMenuTokenDefaults(themeTokens).apply {
        menuItemListDefaults.apply {
            menuItemDefaultTokens.apply {
                colors.backgroundColor.selected = themeTokens.colors.tertiaryBackground
                colors.boarderColor.selected = themeTokens.colors.primaryAccent
                dimensions.boarderWidth.selected = themeTokens.dimensions.size.xxsmall
            }
        }
    }

    public var dimensions: MySelectionMenuDimensionTokenDefaults = MySelectionMenuDimensionTokenDefaults()

    public inner class MySelectionMenuDimensionTokenDefaults {
        public var menuMinimumWidth: Dp = 120.dp
        public var menuMaximumWidth: Dp = 300.dp
    }
}