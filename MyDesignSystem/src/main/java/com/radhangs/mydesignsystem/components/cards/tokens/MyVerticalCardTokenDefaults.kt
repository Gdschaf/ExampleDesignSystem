package com.radhangs.mydesignsystem.components.cards.tokens

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.radhangs.mydesignsystem.theme.tokens.theme.ThemeTokensInterface

public class MyVerticalCardTokenDefaults(private val themeTokens: ThemeTokensInterface) {
    public var cardTokenDefaults: MyCardTokenDefaults = MyCardTokenDefaults(themeTokens)

    public var dimensions: MyVerticalCardDimensionTokenDefaults = MyVerticalCardDimensionTokenDefaults()

    public inner class MyVerticalCardDimensionTokenDefaults {
        public var mediaCornerRadius: CornerSize = themeTokens.dimensions.radius.medium
        public var mediaBottomPadding: Dp = themeTokens.dimensions.size.medium
        public var descriptionTopPadding: Dp = themeTokens.dimensions.size.medium
        public var mediaHeight: Dp = 80.dp
        public var maxCardWidth: Dp = 200.dp
    }
}