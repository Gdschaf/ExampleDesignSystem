package com.radhangs.mydesignsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import com.radhangs.mydesignsystem.theme.tokens.core.CoreTokens
import com.radhangs.mydesignsystem.theme.tokens.core.CoreTokensOptIn
import com.radhangs.mydesignsystem.theme.tokens.theme.ExampleThemeTokens
import com.radhangs.mydesignsystem.theme.tokens.theme.ThemeTokensInterface

@OptIn(CoreTokensOptIn::class)
public class ExampleTheme (
    public val core: CoreTokens,
    public val theme: ThemeTokensInterface
)

@OptIn(CoreTokensOptIn::class)
public val LocalTheme: ProvidableCompositionLocal<ExampleTheme> = staticCompositionLocalOf {
    ExampleTheme(
        core = CoreTokens(),
        theme = ExampleThemeTokens()
    )
}

@OptIn(CoreTokensOptIn::class)
@Composable
public fun ExampleTheme(
    theme: ExampleTheme = ExampleTheme(
        core = CoreTokens(),
        theme = ExampleThemeTokens()
    ),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalTheme provides theme) {
        content()
    }
}