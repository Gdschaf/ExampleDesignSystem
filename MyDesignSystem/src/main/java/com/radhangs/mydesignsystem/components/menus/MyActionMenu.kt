package com.radhangs.mydesignsystem.components.menus

import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.radhangs.mydesignsystem.components.menus.tokens.MyActionMenuTokenDefaults
import com.radhangs.mydesignsystem.theme.ExampleThemeLocal

/**
 * An instance of the [MyMenu] component that has items that are actionable. This usually means that
 * an action is performed when an item is pressed. The [MyActionMenu] should close when an item
 * is pressed and the action is performed.
 *
 * @param expanded A [Boolean] indicating whether the menu is expanded or not.
 * @param onDismissRequest A lambda function invoked when the menu is dismissed.
 * @param items A [List] of [MyMenuData] representing the items to be displayed in the menu.
 * @param onItemPressed A lambda function invoked when an item is pressed, with the item's index and data as parameters.
 * @param modifier A [Modifier] used to adjust the layout or behavior of the menu. Defaults to [Modifier].
 * @param offset A [DpOffset] used to adjust the position of the menu. Defaults to `DpOffset(0.dp, 0.dp)`.
 * @param defaultTokens An instance of [MyActionMenuTokenDefaults] that defines default styling and configuration for the menu.
 * Defaults to a [MyActionMenuTokenDefaults] instance with the current theme.
 */
@Composable
public fun MyActionMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    items: List<MyMenuData>,
    onItemPressed: (Int, MyMenuItemData) -> Unit,
    modifier: Modifier = Modifier,
    offset: DpOffset = DpOffset(0.dp, 0.dp),
    defaultTokens: MyActionMenuTokenDefaults = MyActionMenuTokenDefaults(ExampleThemeLocal.theme)
) {
    MyMenu(
        modifier = Modifier
            .widthIn(
                min = defaultTokens.dimensions.menuMinimumWidth,
                max = defaultTokens.dimensions.menuMaximumWidth
            )
            .then(modifier),
        expanded = expanded,
        onDismissRequest = onDismissRequest,
        items = items,
        selectedItemIndex = null,
        useSelectedCheckmark = false,
        onItemPressed = onItemPressed,
        offset = offset,
        defaultTokens = defaultTokens.menuTokenDefaults
    )
}