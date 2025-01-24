package com.radhangs.mydesignsystem.components.menus

import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.radhangs.mydesignsystem.components.menus.tokens.MySelectionMenuTokenDefaults
import com.radhangs.mydesignsystem.theme.ExampleThemeLocal

/**
 * A composable function that creates a selection menu with selectable items.
 *
 * This function uses [MyMenu] to provide the menu's surface and styling. Items in this menu
 * are selectable and provide visual feedback when selected. The menu does not close when an
 * item is pressed but rather selects the pressed item.
 *
 * @param expanded A [Boolean] indicating whether the menu is expanded or not.
 * @param onDismissRequest A lambda function invoked when the menu is dismissed.
 * @param items A [List] of [MyMenuData] representing the items to be displayed in the menu.
 * @param selectedItemIndex An optional [Int] representing the index of the currently selected item. Defaults to `null`.
 * @param useSelectedCheckmark A [Boolean] indicating whether to show a checkmark for the selected item.
 * @param onItemPressed A lambda function invoked when an item is pressed, with the item's index and data as parameters.
 * @param modifier A [Modifier] used to adjust the layout or behavior of the menu. Defaults to [Modifier].
 * @param offset A [DpOffset] used to adjust the position of the menu. Defaults to `DpOffset(0.dp, 0.dp)`.
 * @param defaultTokens An instance of [MySelectionMenuTokenDefaults] that defines default styling and configuration for the menu.
 * Defaults to a [MySelectionMenuTokenDefaults] instance with the current theme.
 */
@Composable
public fun MySelectionMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    items: List<MyMenuData>,
    selectedItemIndex: Int?,
    useSelectedCheckmark: Boolean,
    onItemPressed: (Int, MyMenuItemData) -> Unit,
    modifier: Modifier = Modifier,
    offset: DpOffset = DpOffset(0.dp, 0.dp),
    defaultTokens: MySelectionMenuTokenDefaults = MySelectionMenuTokenDefaults(ExampleThemeLocal.theme)
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
        selectedItemIndex = selectedItemIndex,
        useSelectedCheckmark = useSelectedCheckmark,
        onItemPressed = onItemPressed,
        offset = offset,
        defaultTokens = defaultTokens.menuTokenDefaults
    )
}