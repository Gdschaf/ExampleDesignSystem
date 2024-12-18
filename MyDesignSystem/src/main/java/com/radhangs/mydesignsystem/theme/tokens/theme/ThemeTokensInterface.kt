package com.radhangs.mydesignsystem.theme.tokens.theme

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.unit.Dp

public interface ThemeTokensInterface {
    public var colors: ThemeColorTokensInterface
    public var dimensions: ThemeDimensionTokensInterface
    public var typography: ThemeTypographyTokensInterface
}

public interface ThemeColorTokensInterface {

}

public interface ThemeDimensionTokensInterface {
    public val size: ThemeSizeTokensInterface
    public val radius: ThemeRadiusTokensInterface
    public val elevation: ThemeElevationTokensInterface
}

public interface ThemeSizeTokensInterface {
    public val xsmall: Dp
    public val small: Dp
    public val medium: Dp
    public val large: Dp
    public val xlarge: Dp
    public val xxlarge: Dp
}

public interface ThemeRadiusTokensInterface {
    public val none: CornerSize
    public val small: CornerSize
    public val medium: CornerSize
    public val large: CornerSize
    public val full: CornerSize
}

public interface ThemeElevationTokensInterface {
    public val none: Dp
    public val low: Dp
    public val medium: Dp
    public val high: Dp
}

public interface ThemeTypographyTokensInterface {

}