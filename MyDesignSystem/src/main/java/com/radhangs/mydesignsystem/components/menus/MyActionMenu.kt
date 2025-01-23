package com.radhangs.mydesignsystem.components.menus

import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.radhangs.mydesignsystem.components.menus.tokens.MyActionMenuTokenDefaults
import com.radhangs.mydesignsystem.components.menus.tokens.MyMenuTokenDefaults
import com.radhangs.mydesignsystem.theme.ExampleThemeLocal

/**
 * An instance of the [MyMenu] component that has items that are actionable. This usually means that
 * an action is performed when an item is pressed. The [MyActionMenu] should close when an item
 * is pressed and the action is performed.
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