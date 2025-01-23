package com.radhangs.mydesignsystem.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.radhangs.mydesignsystem.components.tokens.MyDividerTokenDefaults
import com.radhangs.mydesignsystem.theme.ExampleTheme
import com.radhangs.mydesignsystem.theme.ExampleThemeLocal
import com.radhangs.mydesignsystem.util.DarkModePreview
import com.radhangs.mydesignsystem.util.LightModePreview

/**
 * This is an example of a relatively simple design system component.
 * The benefit of wrapping [HorizontalDivider] with your own component is
 * if the style needed to change app wide, you can just update the default
 * component tokens in one place.
 * This also allows other design system components to use this component and maintain a
 * consistent design language.
 *
 * @param modifier The [Modifier] passed into the [HorizontalDivider] component.
 * @param defaultTokens The default token values that define the style of the component. See
 * [MyDividerTokenDefaults] for more info and default values. Override this to customize the look on
 * a component by component basis/level.
 */
@Composable
public fun MyDivider(
    modifier: Modifier = Modifier,
    defaultTokens: MyDividerTokenDefaults = MyDividerTokenDefaults(ExampleThemeLocal.theme)
) {
    HorizontalDivider(
        modifier = modifier,
        thickness = defaultTokens.dimensions.dividerThickness,
        color = defaultTokens.colors.dividerColor
    )
}

@Composable
@LightModePreview
@DarkModePreview
private fun MyDividerPreview() {
    ExampleTheme {
        MyDivider(
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}