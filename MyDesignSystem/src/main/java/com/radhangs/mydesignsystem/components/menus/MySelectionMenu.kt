package com.radhangs.mydesignsystem.components.menus

import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.radhangs.mydesignsystem.components.menus.tokens.MySelectionMenuTokenDefaults
import com.radhangs.mydesignsystem.theme.ExampleThemeLocal

/**
 * An instance of the [MyMenu] component that has items that are selectable. This means that
 * while items are selectable, they are meant to be pressed an have some sort of visual feedback
 * to indicate that they are selected. The [MySelectionMenu] shouldn't close when an item is pressed
 * but should rather select the pressed item.
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