package com.radhangs.mydesignsystem.components.cards.tokens

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.radhangs.mydesignsystem.theme.tokens.theme.ThemeTokensInterface

public class MyHorizontalCardTokenDefaults(private val themeTokens: ThemeTokensInterface) {
    public var cardTokenDefaults: MyCardTokenDefaults = MyCardTokenDefaults(themeTokens).apply {
        dimensions.contentPadding = themeTokens.dimensions.size.small
    }

    public var dimensions: MyHorizontalCardDimensionTokenDefaults = MyHorizontalCardDimensionTokenDefaults()

    public inner class MyHorizontalCardDimensionTokenDefaults {
        public var mediaCornerRadius: CornerSize = themeTokens.dimensions.radius.medium
        public var mediaEndPadding: Dp = themeTokens.dimensions.size.medium
        public var descriptionTopPadding: Dp = themeTokens.dimensions.size.medium
        public var textEndPadding: Dp = themeTokens.dimensions.size.medium
        public var mediaWidth: Dp = 60.dp
        public var maxCardWidth: Dp = 250.dp
    }
}