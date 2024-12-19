package com.radhangs.mydesignsystem.theme.tokens.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.radhangs.mydesignsystem.theme.tokens.core.CoreTokens
import com.radhangs.mydesignsystem.theme.tokens.core.CoreTokensOptIn
import robotoFont

/**
 * New themes can easily be created following the contents of this file.
 * You could even go as far as reusing a lot of the dimensions and typography tokens or create
 * shared dimensions and typography tokens and just swap out colors for the different themes.
 */
@OptIn(CoreTokensOptIn::class)
public class ExampleThemeTokens(coreColorTokens: CoreTokens.CoreColorTokens) : ThemeTokensInterface {
    override var colors: ThemeColorTokensInterface = ExampleThemeColorTokensLight(coreColorTokens)
    override var dimensions: ThemeDimensionTokensInterface = ExampleThemeDimensionTokens()
    override var typography: ThemeTypographyTokensInterface = ExampleThemeTypographyTokens()

    public inner class ExampleThemeColorTokensLight(coreColorTokens: CoreTokens.CoreColorTokens) : ThemeColorTokensInterface {
        override var primaryBackground: Color = coreColorTokens.gray(5)
        override var secondaryBackground: Color = coreColorTokens.gray(10)
        override var tertiaryBackground: Color = coreColorTokens.gray(20)
        override var primaryContent: Color = coreColorTokens.gray(100)
        override var secondaryContent: Color = coreColorTokens.gray(80)
        override var tertiaryContent: Color = coreColorTokens.gray(60)
        override var primaryAccent: Color = coreColorTokens.blue(50)
        override var secondaryAccent: Color = coreColorTokens.blue(40)
        override var error: Color = coreColorTokens.red(50)
        override var warning: Color = coreColorTokens.yellow(50)
        override var success: Color = coreColorTokens.green(50)
        override var info: Color = coreColorTokens.blue(40)
    }

    public inner class ExampleThemeColorTokensDark(coreColorTokens: CoreTokens.CoreColorTokens) : ThemeColorTokensInterface {
        override var primaryBackground: Color = coreColorTokens.gray(90)
        override var secondaryBackground: Color = coreColorTokens.gray(80)
        override var tertiaryBackground: Color = coreColorTokens.gray(70)
        override var primaryContent: Color = coreColorTokens.gray(0)
        override var secondaryContent: Color = coreColorTokens.gray(10)
        override var tertiaryContent: Color = coreColorTokens.gray(30)
        override var primaryAccent: Color = coreColorTokens.blue(40)
        override var secondaryAccent: Color = coreColorTokens.blue(30)
        override var error: Color = coreColorTokens.red(40)
        override var warning: Color = coreColorTokens.yellow(40)
        override var success: Color = coreColorTokens.green(40)
        override var info: Color = coreColorTokens.blue(30)
    }

    public inner class ExampleThemeDimensionTokens : ThemeDimensionTokensInterface {
        override var size: ThemeSizeTokensInterface = ExampleThemeSizeTokens()
        override var radius: ThemeRadiusTokensInterface = ExampleThemeRadiusTokens()
        override var elevation: ThemeElevationTokensInterface = ExampleThemeElevationTokens()

        public inner class ExampleThemeSizeTokens : ThemeSizeTokensInterface {
            override val xsmall: Dp = 2.dp
            override val small: Dp = 4.dp
            override val medium: Dp = 8.dp
            override val large: Dp = 16.dp
            override val xlarge: Dp = 24.dp
            override val xxlarge: Dp = 32.dp
        }

        public inner class ExampleThemeRadiusTokens : ThemeRadiusTokensInterface {
            override val none: CornerSize = CornerSize(0)
            override val small: CornerSize = CornerSize(4.dp)
            override val medium: CornerSize = CornerSize(8.dp)
            override val large: CornerSize = CornerSize(16.dp)
            override val full: CornerSize = CornerSize(100)
        }

        public inner class ExampleThemeElevationTokens : ThemeElevationTokensInterface {
            override val none: Dp = 0.dp
            override val low: Dp = 2.dp
            override val medium: Dp = 4.dp
            override val high: Dp = 8.dp
        }
    }

    public inner class ExampleThemeTypographyTokens : ThemeTypographyTokensInterface {
        override val heading: ThemeHeadingTypographyTokensInterface = ExampleThemeHeadingTypographyTokens()
        override val body: ThemeBodyTypographyTokensInterface = ExampleThemeBodyTypographyTokens()

        public inner class ExampleThemeHeadingTypographyTokens : ThemeHeadingTypographyTokensInterface {
            override val small: TextStyle = TextStyle(
                fontFamily = robotoFont,
                fontSize = 20.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.sp
            )
            override val medium: TextStyle = TextStyle(
                fontFamily = robotoFont,
                fontSize = 24.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.sp
            )
            override val large: TextStyle = TextStyle(
                fontFamily = robotoFont,
                fontSize = 32.sp,
                lineHeight = 40.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.sp
            )
        }

        public inner class ExampleThemeBodyTypographyTokens : ThemeBodyTypographyTokensInterface {
            override val small: TextStyle = TextStyle(
                fontFamily = robotoFont,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Normal,
                letterSpacing = 0.sp
            )
            override val medium: TextStyle = TextStyle(
                fontFamily = robotoFont,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Normal,
                letterSpacing = 0.sp
            )
            override val large: TextStyle = TextStyle(
                fontFamily = robotoFont,
                fontSize = 18.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.Normal,
                letterSpacing = 0.sp
            )
        }
    }
}

