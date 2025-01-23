package com.radhangs.mydesignsystem.components.menus.tokens

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.radhangs.mydesignsystem.theme.tokens.MyColorTokenState
import com.radhangs.mydesignsystem.theme.tokens.MySizeDimensionTokenState
import com.radhangs.mydesignsystem.theme.tokens.MyTypographyTokenState
import com.radhangs.mydesignsystem.theme.tokens.theme.ThemeTokensInterface

public class MyMenuItemTokenDefaults(private val themeTokens: ThemeTokensInterface) {
    public var colors: MyMenuItemColorTokenDefaults = MyMenuItemColorTokenDefaults()
    public var dimensions: MyMenuItemDimensionTokenDefaults = MyMenuItemDimensionTokenDefaults()
    public var typography: MyMenuItemTypographyTokenDefaults = MyMenuItemTypographyTokenDefaults()

    public inner class MyMenuItemColorTokenDefaults {
        public var iconTint: MyColorTokenState = MyColorTokenState(
            default = themeTokens.colors.primaryContent,
            disabled = Color.Gray /* TODO add disabled colors to theme tokens */
        )
        public var backgroundColor: MyColorTokenState = MyColorTokenState(
            default = themeTokens.colors.primaryBackground
        )
        public var boarderColor: MyColorTokenState = MyColorTokenState(
            default = Color.Transparent
        )
        public var rippleColor: MyColorTokenState? = MyColorTokenState(themeTokens.colors.secondaryBackground)
    }

    public inner class MyMenuItemDimensionTokenDefaults {
        public var boarderWidth: MySizeDimensionTokenState = MySizeDimensionTokenState(
            default = 0.dp
        )
        public var horizontalPadding: Dp = 12.dp
        public var verticalPadding: Dp = themeTokens.dimensions.size.small
        public var iconTextSpacing: Dp = themeTokens.dimensions.size.medium
        public var iconSize: Dp = themeTokens.dimensions.size.xlarge
    }

    public inner class MyMenuItemTypographyTokenDefaults {
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