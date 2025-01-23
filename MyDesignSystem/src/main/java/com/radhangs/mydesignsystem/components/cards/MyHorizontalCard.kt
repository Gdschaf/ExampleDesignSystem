package com.radhangs.mydesignsystem.components.cards

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.max
import com.radhangs.mydesignsystem.components.buttons.MyButtonSurface
import com.radhangs.mydesignsystem.components.buttons.tokens.MyButtonSurfaceTokenDefaults
import com.radhangs.mydesignsystem.components.cards.tokens.MyHorizontalCardTokenDefaults
import com.radhangs.mydesignsystem.theme.ExampleTheme
import com.radhangs.mydesignsystem.theme.ExampleThemeLocal
import com.radhangs.mydesignsystem.util.ASPECT_RATIO
import com.radhangs.mydesignsystem.util.DarkModePreview
import com.radhangs.mydesignsystem.util.LightModePreview
import com.radhangs.mydesignsystem.util.MyComponentMedia
import com.radhangs.mydesignsystem.util.MyUrlMedia
import com.radhangs.mydesignsystem.util.toDp

/**
 * Alternatively could just do a card component and pass in an orientation for vertical or horizontal
 */
@Composable
public fun MyHorizontalCard(
    title: String,
    cardMedia: MyComponentMedia,
    modifier: Modifier = Modifier,
    description: String? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    defaultTokens: MyHorizontalCardTokenDefaults = MyHorizontalCardTokenDefaults(ExampleThemeLocal.theme)
) {
    MyButtonSurface(
        modifier = modifier,
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
        Row (
            modifier = Modifier
                .widthIn(max = defaultTokens.dimensions.maxCardWidth)
                .padding(defaultTokens.cardTokenDefaults.dimensions.contentPadding)
                .semantics(mergeDescendants = true) {
                    // TODO - Add content description
                }
        ) {
            var mediaHeight by remember { mutableIntStateOf(0) }
            cardMedia(
                modifier = Modifier
                    .padding(end = defaultTokens.dimensions.mediaEndPadding)
                    .width(defaultTokens.dimensions.mediaWidth)
                    .clip(RoundedCornerShape(defaultTokens.dimensions.mediaCornerRadius))
                    .onGloballyPositioned {
                        mediaHeight = it.size.height
                    }
            )

            Column(
                modifier = Modifier
                    .heightIn(min = mediaHeight.toDp())
                    .padding(end = defaultTokens.dimensions.textEndPadding),
                verticalArrangement = Arrangement.spacedBy(defaultTokens.dimensions.descriptionTopPadding, Alignment.CenterVertically)
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
            MyHorizontalCard(
                title = "Title",
                cardMedia = MyUrlMedia(
                    url = "https://www.example.com/image.jpg",
                    aspectRatio = ASPECT_RATIO.RATIO_1_1
                ),
                description = "Description"
            )
        }
    }
}

// endregion
