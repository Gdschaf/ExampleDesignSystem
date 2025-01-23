package com.radhangs.mydesignsystem.components.menus.tokens

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.radhangs.mydesignsystem.components.tokens.MyDividerTokenDefaults
import com.radhangs.mydesignsystem.theme.tokens.theme.ThemeTokensInterface

public class MyMenuItemListTokenDefaults(private val themeTokens: ThemeTokensInterface) {
    public var menuItemDefaultTokens: MyMenuItemTokenDefaults = MyMenuItemTokenDefaults(themeTokens).apply {
        dimensions.boarderWidth.focused = themeTokens.dimensions.size.xxsmall
        colors.boarderColor.focused = themeTokens.colors.secondaryAccent
    }
    public var dividerDefaults: MyDividerTokenDefaults = MyDividerTokenDefaults(themeTokens)

    public var dimensions: MyMenuItemListDimensionTokenDefaults = MyMenuItemListDimensionTokenDefaults()

    public inner class MyMenuItemListDimensionTokenDefaults {
        public var dividerVerticalPadding: Dp = themeTokens.dimensions.size.xxsmall
        public var menuItemVerticalPadding: Dp = 0.dp
    }
}