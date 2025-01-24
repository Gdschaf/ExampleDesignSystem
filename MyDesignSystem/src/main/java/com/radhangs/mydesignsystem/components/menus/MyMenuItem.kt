package com.radhangs.mydesignsystem.components.menus

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.radhangs.mydesignsystem.icons.DesignSystemIcon
import com.radhangs.mydesignsystem.icons.DesignSystemIcons
import com.radhangs.mydesignsystem.components.menus.tokens.MyMenuItemTokenDefaults
import com.radhangs.mydesignsystem.theme.ExampleTheme
import com.radhangs.mydesignsystem.theme.ExampleThemeLocal
import com.radhangs.mydesignsystem.util.DarkModePreview
import com.radhangs.mydesignsystem.util.LightModePreview

/**
 * A composable function that creates a menu item with customizable text, icon, and appearance.
 *
 * @param text The text to be displayed on the menu item.
 * @param modifier A [Modifier] used to adjust the layout or behavior of the menu item. Defaults to [Modifier].
 * @param icon An optional [DesignSystemIcon] to be displayed alongside the text. Defaults to `null`.
 * @param enabled A [Boolean] indicating whether the menu item is enabled. Defaults to `true`.
 * @param selected A [Boolean] indicating whether the menu item is selected. Defaults to `false`.
 * @param onItemPressed An optional lambda function invoked when the menu item is pressed. Defaults to `null`.
 * @param defaultTokens An instance of [MyMenuItemTokenDefaults] that defines default styling and configuration for the menu item.
 * Defaults to a [MyMenuItemTokenDefaults] instance with the current theme.
 */
@Composable
internal fun MyMenuItem(
    text: String,
    modifier: Modifier = Modifier,
    icon: DesignSystemIcon? = null,
    enabled: Boolean = true,
    selected: Boolean = false,
    onItemPressed: (() -> Unit)? = null,
    defaultTokens: MyMenuItemTokenDefaults = MyMenuItemTokenDefaults(ExampleThemeLocal.theme)
) {
    val interactionSource = remember { MutableInteractionSource() }
    val dimensions = defaultTokens.dimensions
    val rippleColor: Color? = defaultTokens.colors.rippleColor?.getStateComposable(enabled, interactionSource, selected)?.value
    val boarder = BorderStroke(
        width = defaultTokens.dimensions.boarderWidth.getStateComposable(enabled, interactionSource, selected).value,
        color = defaultTokens.colors.boarderColor.getStateComposable(enabled, interactionSource, selected).value
    )
    Row(
        modifier = modifier
            .run {
                onItemPressed?.let {
                    clickable(
                        interactionSource = interactionSource,
                        indication = rippleColor?.let { ripple(color = rippleColor) },
                        enabled = enabled,
                        onClick = onItemPressed
                    )
                } ?: this
            }
            .background(Color.Gray)
            .background(defaultTokens.colors.backgroundColor.getStateComposable(enabled, interactionSource, selected).value)
            .border(boarder)
            .padding(
                horizontal = dimensions.horizontalPadding,
                vertical = dimensions.verticalPadding
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(dimensions.iconTextSpacing)
    ) {
        icon?.let {
            icon.ToIcon(
                contentDescription = null,
                tint = defaultTokens.colors.iconTint.getStateComposable(enabled, interactionSource).value,
                modifier = Modifier
                    .size(dimensions.iconSize)
            )
        }

        val typography = defaultTokens.typography
        Text(
            text = text,
            style = typography.textStyle.getStateComposable(enabled, interactionSource).value
        )
    }
}

// region Preview

@Composable
@LightModePreview
@DarkModePreview
private fun MyMenuItemPreview() {
    ExampleTheme {
        MyMenuItem(
            text = "Example Menu Item",
            icon = DesignSystemIcons.Image.Filled,
            // modifier = Modifier.fillMaxWidth()
        )
    }
}

// endregion
