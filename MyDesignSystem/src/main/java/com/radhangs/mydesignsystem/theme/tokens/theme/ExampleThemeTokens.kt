package com.radhangs.mydesignsystem.theme.tokens.theme

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * New themes can easily be created following the contents of this file.
 * You could even go as far as reusing a lot of the dimensions and typography tokens or create
 * shared dimensions and typography tokens and just swap out colors for the different themes.
 */
public class ExampleThemeTokens : ThemeTokensInterface {
    override var colors: ThemeColorTokensInterface = ExampleThemeColorTokensLight()
    override var dimensions: ThemeDimensionTokensInterface = ExampleThemeDimensionTokens()
    override var typography: ThemeTypographyTokensInterface = ExampleThemeTypographyTokens()
}

public class ExampleThemeColorTokensLight : ThemeColorTokensInterface {

}

public class ExampleThemeColorTokensDark : ThemeColorTokensInterface {

}

public class ExampleThemeDimensionTokens : ThemeDimensionTokensInterface {
    override var size: ThemeSizeTokensInterface = ExampleThemeSizeTokens()
    override var radius: ThemeRadiusTokensInterface = ExampleThemeRadiusTokens()
    override var elevation: ThemeElevationTokensInterface = ExampleThemeElevationTokens()
}

public class ExampleThemeSizeTokens : ThemeSizeTokensInterface {
    override val xsmall: Dp = 2.dp
    override val small: Dp = 4.dp
    override val medium: Dp = 8.dp
    override val large: Dp = 16.dp
    override val xlarge: Dp = 24.dp
    override val xxlarge: Dp = 32.dp
}

public class ExampleThemeRadiusTokens : ThemeRadiusTokensInterface {
    override val none: CornerSize = CornerSize(0)
    override val small: CornerSize = CornerSize(4.dp)
    override val medium: CornerSize = CornerSize(8.dp)
    override val large: CornerSize = CornerSize(16.dp)
    override val full: CornerSize = CornerSize(100)
}

public class ExampleThemeElevationTokens : ThemeElevationTokensInterface {
    override val none: Dp = 0.dp
    override val low: Dp = 2.dp
    override val medium: Dp = 4.dp
    override val high: Dp = 8.dp
}

public class ExampleThemeTypographyTokens : ThemeTypographyTokensInterface {

}