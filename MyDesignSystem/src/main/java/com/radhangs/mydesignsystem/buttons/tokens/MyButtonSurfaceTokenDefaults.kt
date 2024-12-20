package com.radhangs.mydesignsystem.buttons.tokens

import com.radhangs.mydesignsystem.theme.tokens.MyBooleanTokenState
import com.radhangs.mydesignsystem.theme.tokens.MyColorTokenState
import com.radhangs.mydesignsystem.theme.tokens.MyElevationDimensionTokenState
import com.radhangs.mydesignsystem.theme.tokens.MyRadiusDimensionTokenState
import com.radhangs.mydesignsystem.theme.tokens.MySizeDimensionTokenState
import com.radhangs.mydesignsystem.theme.tokens.theme.ThemeTokensInterface

public class MyButtonSurfaceTokenDefaults(private val themeTokens: ThemeTokensInterface) {
    public var colors: MyButtonSurfaceColorTokenInterface = MyButtonSurfaceColorTokenDefaults()
    public var dimensions: MyButtonSurfaceDimensionTokenInterface = MyButtonSurfaceDimensionTokenDefaults()

    public inner class MyButtonSurfaceColorTokenDefaults: MyButtonSurfaceColorTokenInterface {
        public override var boarderColor: MyColorTokenState = MyColorTokenState(themeTokens.colors.primaryAccent)
        public override var backgroundColor: MyColorTokenState = MyColorTokenState(themeTokens.colors.primaryBackground)
        public override var rippleColor: MyColorTokenState? = null
    }

    public interface MyButtonSurfaceColorTokenInterface {
        public var boarderColor: MyColorTokenState
        public var backgroundColor: MyColorTokenState
        public var rippleColor: MyColorTokenState?
    }

    public inner class MyButtonSurfaceDimensionTokenDefaults: MyButtonSurfaceDimensionTokenInterface {
        public override var borderSize: MySizeDimensionTokenState = MySizeDimensionTokenState(themeTokens.dimensions.size.xsmall)
        public override var borderCornerRadius: MyRadiusDimensionTokenState = MyRadiusDimensionTokenState(themeTokens.dimensions.radius.small)
        public override var borderDashed: MyBooleanTokenState = MyBooleanTokenState(false)
        public override var surfaceElevation: MyElevationDimensionTokenState = MyElevationDimensionTokenState(themeTokens.dimensions.elevation.none)
    }

    public interface MyButtonSurfaceDimensionTokenInterface {
        public var borderSize: MySizeDimensionTokenState
        public var borderCornerRadius: MyRadiusDimensionTokenState
        public var borderDashed: MyBooleanTokenState
        public var surfaceElevation: MyElevationDimensionTokenState
    }
}