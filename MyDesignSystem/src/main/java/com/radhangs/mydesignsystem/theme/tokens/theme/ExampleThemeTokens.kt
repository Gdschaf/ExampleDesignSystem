package com.radhangs.mydesignsystem.theme.tokens.theme

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

}

public class ExampleThemeRadiusTokens : ThemeRadiusTokensInterface {

}

public class ExampleThemeElevationTokens : ThemeElevationTokensInterface {

}

public class ExampleThemeTypographyTokens : ThemeTypographyTokensInterface {

}