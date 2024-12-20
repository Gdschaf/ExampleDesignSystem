package com.radhangs.mydesignsystem.theme.tokens

import androidx.compose.foundation.interaction.FocusInteraction
import androidx.compose.foundation.interaction.HoverInteraction
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

internal interface MyTokenState<T> {
    var default: T
    var hovered: T?
    var focused: T?
    var pressed: T?
    var disabled: T?

    @Composable
    fun getCurrentState(
        enabled: Boolean,
        interactionSource: InteractionSource
    ): T {
        val interactions = remember { mutableStateListOf<Interaction>() }
        LaunchedEffect(interactionSource) {
            interactionSource.interactions.collect { interaction ->
                when (interaction) {
                    is PressInteraction.Press -> {
                        interactions.add(interaction)
                    }
                    is PressInteraction.Release -> {
                        interactions.remove(interaction.press)
                    }
                    is PressInteraction.Cancel -> {
                        interactions.remove(interaction.press)
                    }
                    is FocusInteraction.Focus -> {
                        interactions.add(interaction)
                    }
                    is FocusInteraction.Unfocus -> {
                        interactions.remove(interaction.focus)
                    }
                    is HoverInteraction.Enter -> {
                        interactions.add(interaction)
                    }
                    is HoverInteraction.Exit -> {
                        interactions.remove(interaction.enter)
                    }
                }
            }
        }

        var state: T = default
        if (enabled) {
            when (interactions.lastOrNull()) {
                is PressInteraction.Press -> {
                    pressed?.let {
                        state = it
                    }
                }
                is FocusInteraction.Focus -> {
                    focused?.let {
                        state = it
                    }
                }
                is HoverInteraction.Enter -> {
                    hovered?.let {
                        state = it
                    }
                }
            }
        } else {
            disabled?.let {
                state = it
            }
        }

        return state
    }

    operator fun invoke(): T {
        return default
    }
}

public data class MyColorTokenState(
    override var default: Color,
    override var hovered: Color? = null,
    override var focused: Color? = null,
    override var pressed: Color? = null,
    override var disabled: Color? = null
) : MyTokenState<Color> {
    @Composable
    public fun getStateComposable(
        enabled: Boolean,
        interactionSource: InteractionSource
    ): State<Color> {
        return rememberUpdatedState(getCurrentState(enabled, interactionSource))
    }
}

internal sealed interface MyStateDimension

public data class MySizeDimensionTokenState(
    override var default: Dp,
    override var hovered: Dp? = null,
    override var focused: Dp? = null,
    override var pressed: Dp? = null,
    override var disabled: Dp? = null
) : MyTokenState<Dp>, MyStateDimension {
    @Composable
    public fun getStateComposable(
        enabled: Boolean,
        interactionSource: InteractionSource
    ): State<Dp> {
        return rememberUpdatedState(getCurrentState(enabled, interactionSource))
    }
}

public data class MyRadiusDimensionTokenState(
    override var default: CornerSize,
    override var hovered: CornerSize? = null,
    override var focused: CornerSize? = null,
    override var pressed: CornerSize? = null,
    override var disabled: CornerSize? = null
) : MyTokenState<CornerSize>, MyStateDimension {
    @Composable
    public fun getStateComposable(
        enabled: Boolean,
        interactionSource: InteractionSource
    ): State<CornerSize> {
        return rememberUpdatedState(getCurrentState(enabled, interactionSource))
    }
}

public data class MyElevationDimensionTokenState(
    override var default: Dp,
    override var hovered: Dp? = null,
    override var focused: Dp? = null,
    override var pressed: Dp? = null,
    override var disabled: Dp? = null
) : MyTokenState<Dp>, MyStateDimension {
    @Composable
    public fun getStateComposable(
        enabled: Boolean,
        interactionSource: InteractionSource
    ): State<Dp> {
        val stateValue = getCurrentState(enabled, interactionSource)
        /* TODO add elevation animation here */
        return rememberUpdatedState(stateValue)
    }
}

public data class MyTypographyTokenState(
    override var default: TextStyle,
    override var hovered: TextStyle? = null,
    override var focused: TextStyle? = null,
    override var pressed: TextStyle? = null,
    override var disabled: TextStyle? = null
) : MyTokenState<TextStyle> {
    @Composable
    public fun getStateComposable(
        enabled: Boolean,
        interactionSource: InteractionSource
    ): State<TextStyle> {
        return rememberUpdatedState(getCurrentState(enabled, interactionSource))
    }
}

public data class MyBooleanTokenState(
    override var default: Boolean,
    override var hovered: Boolean? = null,
    override var focused: Boolean? = null,
    override var pressed: Boolean? = null,
    override var disabled: Boolean? = null
) : MyTokenState<Boolean> {
    @Composable
    public fun getStateComposable(
        enabled: Boolean,
        interactionSource: InteractionSource
    ): State<Boolean> {
        return rememberUpdatedState(getCurrentState(enabled, interactionSource))
    }
}