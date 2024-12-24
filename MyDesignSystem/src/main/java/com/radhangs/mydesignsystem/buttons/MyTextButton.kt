package com.radhangs.mydesignsystem.buttons

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.radhangs.mydesignsystem.buttons.tokens.MyButtonSurfaceTokenDefaults
import com.radhangs.mydesignsystem.buttons.tokens.MyTextButtonTokenDefaults
import com.radhangs.mydesignsystem.theme.ExampleTheme
import com.radhangs.mydesignsystem.theme.ExampleThemeLocal
import com.radhangs.mydesignsystem.util.DarkModePreview
import com.radhangs.mydesignsystem.util.LightModePreview

/**
 *
 */
@Composable
public fun MyTextButton(
    text: String,
    onButtonPressed: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    defaultTokens: MyTextButtonTokenDefaults = MyTextButtonTokenDefaults(ExampleThemeLocal.theme)
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
            Text(
                modifier = Modifier.padding(defaultTokens.dimensions.buttonPadding),
                text = text,
                style = defaultTokens.typography.textStyle.getStateComposable(enabled, interactionSource).value
            )
        }
    }
}

// region preview

@Composable
private fun MyTextButtonPreview(enabled: Boolean) {
    ExampleTheme {
        MyTextButton(
            text = "Text Button",
            modifier = Modifier.padding(8.dp),
            enabled = enabled,
            onButtonPressed = { }
        )
    }
}

@LightModePreview
@Composable
private fun MyTextButtonPreviewLight(@PreviewParameter(MyTextButtonPreviewParametersProvider::class) enabled: Boolean) {
    MyTextButtonPreview(enabled)
}

@DarkModePreview
@Composable
private fun MyTextButtonPreviewDark(@PreviewParameter(MyTextButtonPreviewParametersProvider::class) enabled: Boolean) {
    MyTextButtonPreview(enabled)
}

private class MyTextButtonPreviewParametersProvider : PreviewParameterProvider<Boolean> {
    override val values = sequenceOf(
        true,
        false
    )
}

// endregion
