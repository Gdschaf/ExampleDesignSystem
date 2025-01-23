package com.radhangs.mydesignsystem.util

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.radhangs.mydesignsystem.icons.DesignSystemIcon
import com.radhangs.mydesignsystem.icons.DesignSystemIcons
import com.radhangs.mydesignsystem.theme.ExampleThemeLocal
import com.radhangs.mydesignsystem.util.tokens.MyIconMediaTokenDefaults

public enum class ASPECT_RATIO {
    RATIO_16_9,
    RATIO_4_3,
    RATIO_1_1
}

public fun ASPECT_RATIO.toFloat(): Float {
    return when (this) {
        ASPECT_RATIO.RATIO_16_9 -> 16f/9f
        ASPECT_RATIO.RATIO_4_3 -> 4f/3f
        ASPECT_RATIO.RATIO_1_1 -> 1f
    }
}

public sealed interface MyComponentMedia {
    public val aspectRatio: ASPECT_RATIO

    @Composable
    public operator fun invoke(modifier: Modifier)
}

public data class MyUrlMedia(
    private val url: String,
    override val aspectRatio: ASPECT_RATIO = ASPECT_RATIO.RATIO_4_3
): MyComponentMedia {
    @Composable
    override fun invoke(modifier: Modifier) {
        val painter = rememberAsyncImagePainter(model = url)
        val internalModifier = modifier.aspectRatio(aspectRatio.toFloat())
        Box(
            modifier = internalModifier
        ) {
            when (painter.state) {
                is AsyncImagePainter.State.Loading -> {
                    PlaceholderImage(
                        modifier = Modifier.fillMaxSize(),
                        icon = DesignSystemIcons.Image.Outlined,
                        contentDescription = "Loading image"
                    )
                }
                is AsyncImagePainter.State.Error -> {
                    PlaceholderImage(
                        modifier = Modifier.fillMaxSize(),
                        icon = DesignSystemIcons.BrokenImage,
                        contentDescription = "Error loading image"
                    )
                }
                else -> {}
            }

            Image(
                painter = painter,
                contentDescription = "Loaded Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
            )
        }
    }

    @Composable
    private fun PlaceholderImage(
        modifier: Modifier,
        icon: DesignSystemIcon,
        contentDescription: String
    ) {
        Box(modifier = modifier.background(ExampleThemeLocal.theme.colors.tertiaryBackground)) {
            icon.ToIcon(
                modifier = Modifier.align(Alignment.Center),
                contentDescription = contentDescription,
                tint = ExampleThemeLocal.theme.colors.tertiaryContent
            )
        }
    }
}

public data class MyIconMedia(
    private val icon: DesignSystemIcon,
    private val contentDescrambler: String?,
    private val defaultTokens: MyIconMediaTokenDefaults? = null,
    override val aspectRatio: ASPECT_RATIO = ASPECT_RATIO.RATIO_4_3
): MyComponentMedia {
    @Composable
    override fun invoke(modifier: Modifier) {
        val internalModifier = modifier.aspectRatio(aspectRatio.toFloat())
        val tokens = defaultTokens ?: MyIconMediaTokenDefaults(ExampleThemeLocal.theme)
        Box(
            modifier = internalModifier.background(tokens.colors.backgroundColor)
        ) {
            icon.ToIcon(
                modifier = Modifier.align(Alignment.Center).size(tokens.dimensions.iconSize),
                contentDescription = contentDescrambler,
                tint = tokens.colors.iconTint
            )
        }
    }
}

public data class MyDrawableMedia(
    @DrawableRes private val  drawableId: Int,
    override val aspectRatio: ASPECT_RATIO = ASPECT_RATIO.RATIO_4_3
): MyComponentMedia {
    @Composable
    override fun invoke(modifier: Modifier) {
        val internalModifier = modifier.aspectRatio(aspectRatio.toFloat())
        Image(
            painter = painterResource(id = drawableId),
            contentDescription = "Drawable Image",
            contentScale = ContentScale.Crop,
            modifier = internalModifier
        )
    }
}