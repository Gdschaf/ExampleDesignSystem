package com.radhangs.mydesignsystem.theme

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import com.radhangs.mydesignsystem.theme.tokens.core.CoreTokens
import com.radhangs.mydesignsystem.theme.tokens.core.CoreTokensOptIn
import com.radhangs.mydesignsystem.theme.tokens.theme.ExampleThemeTokens
import com.radhangs.mydesignsystem.theme.tokens.theme.ThemeTokensInterface

@OptIn(CoreTokensOptIn::class)
public data class ExampleTheme(
    public val coreTokens: CoreTokens = CoreTokens(),
    public val themeTokens: ThemeTokensInterface = ExampleThemeTokens(coreTokens.colors)
)

@OptIn(CoreTokensOptIn::class)
public object ExampleThemeLocal {
    public val core: CoreTokens
        @Composable
        get() = localCoreTokens.current

    public val theme: ThemeTokensInterface
        @Composable
        get() = localThemeTokens.current
}

@OptIn(CoreTokensOptIn::class)
private val localCoreTokens: ProvidableCompositionLocal<CoreTokens> = staticCompositionLocalOf {
    error("No localCoreTokens provided")
}

private val localThemeTokens: ProvidableCompositionLocal<ThemeTokensInterface> = staticCompositionLocalOf {
    error("No localThemeTokens provided")
}

@OptIn(CoreTokensOptIn::class, ExperimentalMaterial3Api::class)
@Composable
public fun ExampleTheme(
    theme: ExampleTheme = ExampleTheme(),
    content: @Composable () -> Unit
) {
    val exampleRippleTheme = exampleRippleTheme()
    CompositionLocalProvider(
        localCoreTokens provides theme.coreTokens,
        localThemeTokens provides  theme.themeTokens,
        LocalRippleConfiguration provides exampleRippleTheme
    ) {
        content()
    }
}