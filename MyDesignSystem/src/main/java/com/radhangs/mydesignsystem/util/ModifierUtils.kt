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
import androidx.compose.ui.semantics.CollectionInfo
import androidx.compose.ui.semantics.CollectionItemInfo
import androidx.compose.ui.semantics.collectionInfo
import androidx.compose.ui.semantics.collectionItemInfo
import androidx.compose.ui.semantics.semantics
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

/**
 * Helper modifier to assign semantics collection info to a vertical list of components
 *
 * @param count The number of items in the collection.
 */
public fun Modifier.verticalCollectionInfo(
    count: Int
): Modifier = this.semantics {
    collectionInfo = CollectionInfo(rowCount = count, columnCount = 1)
}

/**
 * Helper modifier to assign the collection item info semantics to each element in a vertical
 * collection of items.
 *
 * @param index The index of the element in the list of items
 */
public fun Modifier.verticalCollectionItemInfo(
    index: Int
): Modifier = this.semantics {
    collectionItemInfo = CollectionItemInfo(
        rowIndex = index,
        rowSpan = 1,
        columnIndex = 0,
        columnSpan = 1
    )
}

/**
 * Helper modifier to assign semantics collection info to a horizontal list of components
 *
 * @param count The number of items in the collection.
 */
public fun Modifier.horizontalCollectionInfo(
    count: Int
): Modifier = this.semantics {
    collectionInfo = CollectionInfo(rowCount = 1, columnCount = count)
}

/**
 * Helper modifier to assign the collection item info semantics to each element in a horizontal
 * collection of items.
 *
 * @param index The index of the element in the list of items
 */
public fun Modifier.horizontalCollectionItemInfo(
    index: Int
): Modifier = this.semantics {
    collectionItemInfo = CollectionItemInfo(
        rowIndex = 0,
        rowSpan = 1,
        columnIndex = index,
        columnSpan = 1
    )
}

