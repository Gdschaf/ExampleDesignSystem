package com.radhangs.mydesignsystem.components.buttons.tokens

import androidx.compose.foundation.shape.CornerSize
import com.radhangs.mydesignsystem.theme.tokens.MyBooleanTokenState
import com.radhangs.mydesignsystem.theme.tokens.MyColorTokenState
import com.radhangs.mydesignsystem.theme.tokens.MyElevationDimensionTokenState
import com.radhangs.mydesignsystem.theme.tokens.MySizeDimensionTokenState

public data class MyButtonSurfaceTokenDefaults(
    public var colors: MyButtonSurfaceColorTokenInterface,
    public var dimensions: MyButtonSurfaceDimensionTokenInterface
) {
    public interface MyButtonSurfaceColorTokenInterface {
        public var boarderColor: MyColorTokenState
        public var backgroundColor: MyColorTokenState
        public var rippleColor: MyColorTokenState?
    }

    public interface MyButtonSurfaceDimensionTokenInterface {
        public var borderSize: MySizeDimensionTokenState
        public var borderCornerRadius: CornerSize
        public var borderDashed: MyBooleanTokenState
        public var surfaceElevation: MyElevationDimensionTokenState
    }
}