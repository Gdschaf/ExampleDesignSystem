package com.radhangs.mydesignsystem.components.menus.tokens

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.graphics.Color
import com.radhangs.mydesignsystem.theme.tokens.MyColorTokenState
import com.radhangs.mydesignsystem.theme.tokens.theme.ThemeTokensInterface

public class MyMenuTokenDefaults(private val themeTokens: ThemeTokensInterface) {
    public var menuItemListDefaults: MyMenuItemListTokenDefaults = MyMenuItemListTokenDefaults(themeTokens).apply {
        menuItemDefaultTokens = MyMenuItemTokenDefaults(themeTokens).apply {
            colors.backgroundColor = MyColorTokenState(
                default = themeTokens.colors.secondaryBackground,
                focused = themeTokens.colors.tertiaryBackground
            )
            colors.boarderColor = MyColorTokenState(
                default = Color.Transparent,
                focused = themeTokens.colors.primaryAccent
            )
        }
    }

    public var dimensions: MyMenuDimensionTokenDefaults = MyMenuDimensionTokenDefaults()
    public var colors: MyMenuColorTokenDefaults = MyMenuColorTokenDefaults()

    public inner class MyMenuDimensionTokenDefaults {
        public var menuCornerRadius: CornerSize = themeTokens.dimensions.radius.small
    }

    public inner class MyMenuColorTokenDefaults {
        public var menuBackgroundColor: Color = themeTokens.colors.secondaryBackground
    }
}