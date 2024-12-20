package com.radhangs.mydesignsystem.theme.tokens.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

public interface ThemeTokensInterface {
    public var colors: ThemeColorTokensInterface
    public var dimensions: ThemeDimensionTokensInterface
    public var typography: ThemeTypographyTokensInterface
}

public interface ThemeColorTokensInterface {
    public var primaryBackground: Color
    public var secondaryBackground: Color
    public var tertiaryBackground: Color
    public var primaryContent: Color
    public var secondaryContent: Color
    public var tertiaryContent: Color
    public var primaryAccent: Color
    public var secondaryAccent: Color
    public var error: Color
    public var warning: Color
    public var success: Color
    public var info: Color
}

public interface ThemeDimensionTokensInterface {
    public val size: ThemeSizeTokensInterface
    public val radius: ThemeRadiusTokensInterface
    public val elevation: ThemeElevationTokensInterface
}

public interface ThemeSizeTokensInterface {
    public val xxsmall: Dp
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
    public val heading: ThemeHeadingTypographyTokensInterface
    public val body: ThemeBodyTypographyTokensInterface
}

public interface ThemeHeadingTypographyTokensInterface {
    public val small: TextStyle
    public val medium: TextStyle
    public val large: TextStyle
}

public interface ThemeBodyTypographyTokensInterface {
    public val small: TextStyle
    public val medium: TextStyle
    public val large: TextStyle
}

