package com.radhangs.mydesignsystem.components.buttons.tokens

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.radhangs.mydesignsystem.theme.tokens.MyBooleanTokenState
import com.radhangs.mydesignsystem.theme.tokens.MyColorTokenState
import com.radhangs.mydesignsystem.theme.tokens.MyElevationDimensionTokenState
import com.radhangs.mydesignsystem.theme.tokens.MySizeDimensionTokenState
import com.radhangs.mydesignsystem.theme.tokens.theme.ThemeTokensInterface

public class MyIconButtonTokenDefaults(private val themeTokens: ThemeTokensInterface) {
    public var colors: MyIconButtonColorTokenDefaults = MyIconButtonColorTokenDefaults()
    public var dimensions: MyIconButtonDimensionTokenDefaults = MyIconButtonDimensionTokenDefaults()

    public inner class MyIconButtonColorTokenDefaults:
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

        public var iconTint: MyColorTokenState = MyColorTokenState(
            default = themeTokens.colors.primaryContent,
            disabled = Color.Gray /* TODO add disabled colors to theme tokens */
        )
    }

    public inner class MyIconButtonDimensionTokenDefaults:
        MyButtonSurfaceTokenDefaults.MyButtonSurfaceDimensionTokenInterface {
        override var borderSize: MySizeDimensionTokenState = MySizeDimensionTokenState(
            default = themeTokens.dimensions.size.xxsmall,
            focused = themeTokens.dimensions.size.xsmall
        )
        override var borderCornerRadius: CornerSize = themeTokens.dimensions.radius.full
        override var borderDashed: MyBooleanTokenState = MyBooleanTokenState(
            default = false,
            disabled = true
        )
        override var surfaceElevation: MyElevationDimensionTokenState = MyElevationDimensionTokenState(themeTokens.dimensions.elevation.none)

        public var minimumButtonSize: Dp = 40.dp
        public var iconSize: Dp = themeTokens.dimensions.size.large
        public var iconPadding: Dp = themeTokens.dimensions.size.medium
    }
}