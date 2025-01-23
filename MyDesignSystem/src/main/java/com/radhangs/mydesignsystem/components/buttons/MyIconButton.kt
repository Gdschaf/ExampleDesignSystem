package com.radhangs.mydesignsystem.components.buttons

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.radhangs.mydesignsystem.components.buttons.tokens.MyButtonSurfaceTokenDefaults
import com.radhangs.mydesignsystem.components.buttons.tokens.MyIconButtonTokenDefaults
import com.radhangs.mydesignsystem.icons.DesignSystemIcon
import com.radhangs.mydesignsystem.icons.DesignSystemIcons
import com.radhangs.mydesignsystem.theme.ExampleTheme
import com.radhangs.mydesignsystem.theme.ExampleThemeLocal
import com.radhangs.mydesignsystem.util.DarkModePreview
import com.radhangs.mydesignsystem.util.LightModePreview

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
        modifier = modifier,
        onButtonPressed = onButtonPressed,
        enabled = enabled,
        onClickLabel = null,
        role = Role.Button,
        interactionSource = interactionSource,
        defaultTokens = MyButtonSurfaceTokenDefaults(
            colors = defaultTokens.colors,
            dimensions = defaultTokens.dimensions
        )
    ) {
        Box(
            modifier = Modifier
                .defaultMinSize(
                    minWidth = defaultTokens.dimensions.minimumButtonSize,
                    minHeight = defaultTokens.dimensions.minimumButtonSize
                ),
            contentAlignment = Alignment.Center
        ) {
            designSystemIcon.ToIcon(
                modifier = Modifier
                    .padding(defaultTokens.dimensions.iconPadding)
                    .size(defaultTokens.dimensions.iconSize),
                contentDescription = null,
                tint = defaultTokens.colors.iconTint.getStateComposable(enabled, interactionSource).value
            )
        }
    }
}

// region preview

@Composable
@LightModePreview
@DarkModePreview
private fun MyIconButtonPreview(@PreviewParameter(MyIconButtonPreviewParametersProvider::class) enabled: Boolean) {
    ExampleTheme {
        MyIconButton(
            modifier = Modifier.padding(8.dp),
            designSystemIcon = DesignSystemIcons.Image.Outlined,
            enabled = enabled,
            onButtonPressed = { }
        )
    }
}

private class MyIconButtonPreviewParametersProvider : PreviewParameterProvider<Boolean> {
    override val values = sequenceOf(
        true,
        false
    )
}

// endregion
