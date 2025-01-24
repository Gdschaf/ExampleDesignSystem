package com.radhangs.mydesignsystem.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.radhangs.mydesignsystem.components.buttons.tokens.MyButtonSurfaceTokenDefaults
import com.radhangs.mydesignsystem.util.dashedBorder

/**
 * A composable function that provides a surface for a button with customizable behavior and appearance.
 *
 * @param modifier A [Modifier] used to adjust the layout or behavior of the button surface.
 * @param onButtonPressed A lambda function invoked when the button is pressed.
 * @param enabled A [Boolean] indicating whether the button is enabled or not.
 * @param onClickLabel An optional [String] describing the action for accessibility purposes. Useful for screen readers.
 * @param role An optional [Role] defining the semantic role of the button (e.g., `Button`, `Checkbox`).
 * @param interactionSource A [MutableInteractionSource] to track interaction events (e.g., press, hover, focus) for the button.
 * @param defaultTokens An instance of [MyButtonSurfaceTokenDefaults] that defines default styling and configuration for the button.
 * @param buttonContent A composable lambda providing the content to be displayed within the button.
 */
@Composable
public fun MyButtonSurface(
    modifier: Modifier,
    onButtonPressed: () -> Unit,
    enabled: Boolean,
    onClickLabel: String?,
    role: Role?,
    interactionSource: MutableInteractionSource,
    defaultTokens: MyButtonSurfaceTokenDefaults,
    buttonContent: @Composable () -> Unit
) {
    val dashedBorder: Boolean = defaultTokens.dimensions.borderDashed.getStateComposable(enabled, interactionSource).value
    val surfaceElevation: Dp = defaultTokens.dimensions.surfaceElevation.getStateComposable(enabled, interactionSource).value
    val surfaceShape = RoundedCornerShape(defaultTokens.dimensions.borderCornerRadius)
    val borderStroke = BorderStroke(
        width = defaultTokens.dimensions.borderSize.getStateComposable(enabled, interactionSource).value,
        color = defaultTokens.colors.boarderColor.getStateComposable(enabled, interactionSource).value
    )
    val rippleColor: Color? = defaultTokens.colors.rippleColor?.getStateComposable(enabled, interactionSource)?.value

    val elevation = LocalAbsoluteTonalElevation.current + surfaceElevation
    CompositionLocalProvider(
        LocalAbsoluteTonalElevation provides elevation
    ) {
        Box(
            modifier = modifier
                .minimumInteractiveComponentSize()
                .shadow(surfaceElevation, surfaceShape)
                .run {
                    if (dashedBorder) {
                        dashedBorder(
                            borderStroke,
                            surfaceShape,
                            dashWidth = 4.dp, /* TODO tokenize the dash width and gap */
                            dashGap = 3.dp
                        )
                    } else {
                        border(borderStroke, surfaceShape)
                    }
                }
                .run {
                    if (surfaceElevation <= 0.dp) {
                        clip(surfaceShape)
                    } else {
                        this
                    }
                }
                .background(
                    color = defaultTokens.colors.backgroundColor.getStateComposable(
                        enabled = enabled,
                        interactionSource = interactionSource
                    ).value,
                    shape = surfaceShape
                )
                .clickable(
                    interactionSource = interactionSource,
                    indication = rippleColor?.let { ripple(color = rippleColor) },
                    enabled = enabled,
                    onClickLabel = onClickLabel,
                    role = role,
                    onClick = onButtonPressed
                ),
            propagateMinConstraints = true
        ) {
            buttonContent()
        }
    }
}
