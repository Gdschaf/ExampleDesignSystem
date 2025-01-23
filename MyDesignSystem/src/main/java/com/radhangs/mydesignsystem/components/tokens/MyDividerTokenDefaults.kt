package com.radhangs.mydesignsystem.components.tokens

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.radhangs.mydesignsystem.theme.tokens.theme.ThemeTokensInterface

public class MyDividerTokenDefaults(private val themeTokens: ThemeTokensInterface) {
    public var colors: MyDividerColorTokenDefaults = MyDividerColorTokenDefaults()
    public var dimensions: MyDividerDimensionTokenDefaults = MyDividerDimensionTokenDefaults()

    public inner class MyDividerColorTokenDefaults {
        public var dividerColor: Color = themeTokens.colors.secondaryContent
    }

    public inner class MyDividerDimensionTokenDefaults {
        public var dividerThickness: Dp = themeTokens.dimensions.size.xxsmall
    }
}