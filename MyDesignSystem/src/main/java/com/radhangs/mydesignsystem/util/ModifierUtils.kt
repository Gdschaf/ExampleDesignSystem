package com.radhangs.mydesignsystem.util

import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp

/**
 * Reference this link for more information:
 * https://medium.com/@kappdev/dashed-borders-in-jetpack-compose-a-comprehensive-guide-de990a944c4c
 */
public fun Modifier.dashedBorder(
    border: BorderStroke,
    shape: Shape = RectangleShape,
    dashWidth: Dp,
    dashGap: Dp,
    cap: StrokeCap = StrokeCap.Round
): Modifier = this.drawWithContent {
    val strokeWidth = border.width.toPx()
    // val insetSize = Size(size.width - strokeWidth, size.height - strokeWidth)
    val insetSize = Size(size.width, size.height)

    val outline = shape.createOutline(
        size = insetSize,
        layoutDirection = layoutDirection,
        density = this
    )

    val dashedStroke = Stroke(
        cap = cap,
        width = strokeWidth, // border.width.toPx(),
        pathEffect = PathEffect.dashPathEffect(
            intervals = floatArrayOf(dashWidth.toPx(), dashGap.toPx())
        )
    )

    // Draw the content
    drawContent()

    // Draw the border
    drawOutline(
        outline = outline,
        style = dashedStroke,
        brush = border.brush
    )
}