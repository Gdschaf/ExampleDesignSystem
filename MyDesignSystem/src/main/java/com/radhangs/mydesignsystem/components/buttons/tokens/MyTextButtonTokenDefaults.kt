package com.radhangs.mydesignsystem.components.buttons.tokens

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.radhangs.mydesignsystem.theme.tokens.MyBooleanTokenState
import com.radhangs.mydesignsystem.theme.tokens.MyColorTokenState
import com.radhangs.mydesignsystem.theme.tokens.MyElevationDimensionTokenState
import com.radhangs.mydesignsystem.theme.tokens.MySizeDimensionTokenState
import com.radhangs.mydesignsystem.theme.tokens.MyTypographyTokenState
import com.radhangs.mydesignsystem.theme.tokens.theme.ThemeTokensInterface

public class MyTextButtonTokenDefaults(private val themeTokens: ThemeTokensInterface) {
    public var colors: MyTextButtonColorTokenDefaults = MyTextButtonColorTokenDefaults()
    public var dimensions: MyTextButtonDimensionTokenDefaults = MyTextButtonDimensionTokenDefaults()
    public var typography: MyTextButtonTypographyTokenDefaults = MyTextButtonTypographyTokenDefaults()

    public inner class MyTextButtonColorTokenDefaults:
        MyButtonSurfaceTokenDefaults.MyButtonSurfaceColorTokenInterface {
        override var boarderColor: MyColorTokenState = MyColorTokenState(
            default = themeTokens.colors.primaryAccent,
            disabled = Color.Gray /* TODO add disabled colors to theme tokens */
        )
        override var backgroundColor: MyColorTokenState = MyColorTokenState(
            default = themeTokens.colors.primaryBackground,
            pressed = themeTokens.colors.tertiaryBackground,
            disabled = Color.LightGray /* TODO add disabled colors to theme tokens */
        )
        override var rippleColor: MyColorTokenState? = MyColorTokenState(themeTokens.colors.secondaryBackground)
    }

    public inner class MyTextButtonDimensionTokenDefaults:
        MyButtonSurfaceTokenDefaults.MyButtonSurfaceDimensionTokenInterface {
        override var borderSize: MySizeDimensionTokenState = MySizeDimensionTokenState(
            default = themeTokens.dimensions.size.xxsmall,
            focused = themeTokens.dimensions.size.xsmall
        )
        override var borderCornerRadius: CornerSize = themeTokens.dimensions.radius.medium
        override var borderDashed: MyBooleanTokenState = MyBooleanTokenState(
            default = false,
            disabled = true
        )
        override var surfaceElevation: MyElevationDimensionTokenState = MyElevationDimensionTokenState(themeTokens.dimensions.elevation.none)

        public var minimumButtonSize: Dp = 40.dp
        public var buttonPadding: Dp = themeTokens.dimensions.size.medium
    }

    public inner class MyTextButtonTypographyTokenDefaults {
        public var textStyle: MyTypographyTokenState = MyTypographyTokenState(
            default = themeTokens.typography.body.medium.copy(
                color = themeTokens.colors.primaryContent
            ),
            disabled = themeTokens.typography.body.medium.copy(
                color = Color.Gray /* TODO add disabled colors to theme tokens */
            )
        )
    }
}