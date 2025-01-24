package com.radhangs.mydesignsystem.components.cards.tokens

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.radhangs.mydesignsystem.components.buttons.tokens.MyButtonSurfaceTokenDefaults
import com.radhangs.mydesignsystem.theme.tokens.MyBooleanTokenState
import com.radhangs.mydesignsystem.theme.tokens.MyColorTokenState
import com.radhangs.mydesignsystem.theme.tokens.MyElevationDimensionTokenState
import com.radhangs.mydesignsystem.theme.tokens.MySizeDimensionTokenState
import com.radhangs.mydesignsystem.theme.tokens.theme.ThemeTokensInterface

public class MyCardTokenDefaults(private val themeTokens: ThemeTokensInterface) {
    public var colors: MyCardColorTokenDefaults = MyCardColorTokenDefaults()
    public var dimensions: MyCardDimensionTokenDefaults = MyCardDimensionTokenDefaults()
    public var typography: MyCardTypographyTokenDefaults = MyCardTypographyTokenDefaults()

    public inner class MyCardColorTokenDefaults: MyButtonSurfaceTokenDefaults.MyButtonSurfaceColorTokenInterface {
        override var boarderColor: MyColorTokenState = MyColorTokenState(
            default = Color.Transparent,
            focused = themeTokens.colors.primaryAccent
        )
        override var backgroundColor: MyColorTokenState = MyColorTokenState(
            default = themeTokens.colors.primaryBackground,
            pressed = themeTokens.colors.tertiaryBackground
        )
        override var rippleColor: MyColorTokenState? = MyColorTokenState(
            default = themeTokens.colors.secondaryBackground
        )
    }

    public inner class MyCardDimensionTokenDefaults: MyButtonSurfaceTokenDefaults.MyButtonSurfaceDimensionTokenInterface {
        override var borderSize: MySizeDimensionTokenState = MySizeDimensionTokenState(
            default = themeTokens.dimensions.size.xsmall
        )
        override var borderCornerRadius: CornerSize = themeTokens.dimensions.radius.medium
        override var borderDashed: MyBooleanTokenState = MyBooleanTokenState(
            default = false
        )
        override var surfaceElevation: MyElevationDimensionTokenState = MyElevationDimensionTokenState(
            themeTokens.dimensions.elevation.low
        )
        public var contentPadding: Dp = themeTokens.dimensions.size.medium
    }

    public inner class MyCardTypographyTokenDefaults {
        public var title: TextStyle = themeTokens.typography.heading.small.copy(
            color = themeTokens.colors.primaryContent
        )
        public var description: TextStyle = themeTokens.typography.body.small.copy(
            color = themeTokens.colors.secondaryContent
        )
    }
}