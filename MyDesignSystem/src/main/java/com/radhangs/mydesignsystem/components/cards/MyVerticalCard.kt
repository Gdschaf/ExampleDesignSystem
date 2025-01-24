package com.radhangs.mydesignsystem.components.cards

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.radhangs.mydesignsystem.components.buttons.MyButtonSurface
import com.radhangs.mydesignsystem.components.buttons.tokens.MyButtonSurfaceTokenDefaults
import com.radhangs.mydesignsystem.components.cards.tokens.MyVerticalCardTokenDefaults
import com.radhangs.mydesignsystem.theme.ExampleTheme
import com.radhangs.mydesignsystem.theme.ExampleThemeLocal
import com.radhangs.mydesignsystem.util.ASPECT_RATIO
import com.radhangs.mydesignsystem.util.DarkModePreview
import com.radhangs.mydesignsystem.util.LightModePreview
import com.radhangs.mydesignsystem.util.MyComponentMedia
import com.radhangs.mydesignsystem.util.MyUrlMedia
import com.radhangs.mydesignsystem.util.toDp

/**
 * A composable function that creates a vertical card with customizable content and appearance.
 *
 * @param title The title text to be displayed on the card.
 * @param cardMedia A [MyComponentMedia] instance representing the media content to be displayed on the card.
 * @param modifier A [Modifier] used to adjust the layout or behavior of the card. Defaults to [Modifier].
 * @param description An optional description text to be displayed on the card. Defaults to `null`.
 * @param interactionSource A [MutableInteractionSource] to track interaction events for the card.
 * Defaults to a new instance of [MutableInteractionSource].
 * @param defaultTokens An instance of [MyVerticalCardTokenDefaults] that defines default styling and configuration for the card.
 * Defaults to a [MyVerticalCardTokenDefaults] instance with the current theme.
 */
@Composable
public fun MyVerticalCard(
    title: String,
    cardMedia: MyComponentMedia,
    modifier: Modifier = Modifier,
    description: String? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    defaultTokens: MyVerticalCardTokenDefaults = MyVerticalCardTokenDefaults(ExampleThemeLocal.theme)
) {
    MyButtonSurface(
        modifier = modifier.widthIn(max = defaultTokens.dimensions.maxCardWidth),
        onButtonPressed = { },
        enabled = true,
        onClickLabel = null,
        role = null,
        interactionSource = interactionSource,
        defaultTokens = MyButtonSurfaceTokenDefaults(
            colors = defaultTokens.cardTokenDefaults.colors,
            dimensions = defaultTokens.cardTokenDefaults.dimensions
        )
    ) {
        Column(
            modifier = Modifier
                .padding(defaultTokens.cardTokenDefaults.dimensions.contentPadding)
                .semantics(mergeDescendants = true) {
                    // TODO - Add content description
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var mediaWidth by remember { mutableIntStateOf(0) }
            cardMedia(
                modifier = Modifier
                    .padding(bottom = defaultTokens.dimensions.mediaBottomPadding)
                    .height(defaultTokens.dimensions.mediaHeight)
                    .clip(RoundedCornerShape(defaultTokens.dimensions.mediaCornerRadius))
                    .onGloballyPositioned {
                        mediaWidth = it.size.width
                    }
            )

            Column(
                modifier = Modifier.widthIn(min = mediaWidth.toDp()),
                verticalArrangement = Arrangement.spacedBy(defaultTokens.dimensions.descriptionTopPadding)
            ) {
                Text(
                    text = title,
                    style = defaultTokens.cardTokenDefaults.typography.title
                )

                description?.let {
                    Text(
                        text = it,
                        style = defaultTokens.cardTokenDefaults.typography.description
                    )
                }
            }
        }
    }
}

// region preview

@Composable
@LightModePreview
@DarkModePreview
private fun MyVerticalCardPreview() {
    ExampleTheme {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            MyVerticalCard(
                title = "Title",
                cardMedia = MyUrlMedia(
                    url = "https://www.example.com/image.jpg",
                    aspectRatio = ASPECT_RATIO.RATIO_4_3
                ),
                description = "Description"
            )
        }
    }
}

// endregion
