package com.radhangs.mydesignsystem.buttons

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.radhangs.mydesignsystem.buttons.tokens.MyButtonSurfaceTokenDefaults
import com.radhangs.mydesignsystem.buttons.tokens.MyIconButtonTokenDefaults
import com.radhangs.mydesignsystem.icons.DesignSystemIcon
import com.radhangs.mydesignsystem.icons.DesignSystemIcons
import com.radhangs.mydesignsystem.theme.ExampleTheme
import com.radhangs.mydesignsystem.theme.ExampleThemeLocal

/**
 *
 */
@Composable
public fun MyIconButton(
    designSystemIcon: DesignSystemIcon,
    onButtonPressed: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    defaultTokens: MyIconButtonTokenDefaults = MyIconButtonTokenDefaults(ExampleThemeLocal.theme)
) {
    MyButtonSurface(
        modifier = modifier
            .widthIn(defaultTokens.dimensions.minimumButtonSize.default)
            .heightIn(defaultTokens.dimensions.minimumButtonSize.default),
        onButtonPressed = onButtonPressed,
        enabled = enabled,
        role = Role.Button,
        interactionSource = interactionSource,
        defaultTokens = MyButtonSurfaceTokenDefaults(ExampleThemeLocal.theme).apply {
            colors = defaultTokens.colors
            dimensions = defaultTokens.dimensions
        }
    ) {
        designSystemIcon.ToIcon(
            modifier = Modifier.size(defaultTokens.dimensions.iconSize.default),
            contentDescription = null,
            tint = defaultTokens.colors.iconTint.getStateComposable(enabled, interactionSource).value
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MyIconButtonPreview() {
    ExampleTheme {
        MyIconButton(
            modifier = Modifier.padding(8.dp),
            designSystemIcon = DesignSystemIcons.Image.Outlined,
            onButtonPressed = { }
        )
    }
}