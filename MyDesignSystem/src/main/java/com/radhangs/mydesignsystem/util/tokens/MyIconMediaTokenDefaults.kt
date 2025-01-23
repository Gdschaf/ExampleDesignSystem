package com.radhangs.mydesignsystem.util.tokens

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.radhangs.mydesignsystem.theme.tokens.theme.ThemeTokensInterface

public class MyIconMediaTokenDefaults(private val themeTokens: ThemeTokensInterface) {
    public var colors: MyIconMediaColorTokenDefaults = MyIconMediaColorTokenDefaults()
    public var dimensions: MyIconMediaDimensionTokenDefaults = MyIconMediaDimensionTokenDefaults()

    public inner class MyIconMediaColorTokenDefaults {
        public var iconTint: Color = themeTokens.colors.tertiaryContent
        public var backgroundColor: Color = themeTokens.colors.tertiaryBackground
    }

    public inner class MyIconMediaDimensionTokenDefaults {
        public var iconSize: Dp = themeTokens.dimensions.size.xxlarge
    }
}