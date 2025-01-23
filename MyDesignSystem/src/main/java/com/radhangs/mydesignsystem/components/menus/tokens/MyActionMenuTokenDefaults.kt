package com.radhangs.mydesignsystem.components.menus.tokens

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.radhangs.mydesignsystem.theme.tokens.theme.ThemeTokensInterface

public class MyActionMenuTokenDefaults(themeTokens: ThemeTokensInterface) {
    public var menuTokenDefaults: MyMenuTokenDefaults = MyMenuTokenDefaults(themeTokens)

    public var dimensions: MyActionMenuDimensionTokenDefaults = MyActionMenuDimensionTokenDefaults()

    public inner class MyActionMenuDimensionTokenDefaults {
        public var menuMinimumWidth: Dp = 120.dp
        public var menuMaximumWidth: Dp = 300.dp
    }
}