package com.radhangs.mydesignsystem.components.menus

import android.view.KeyEvent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.input.key.utf16CodePoint
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.radhangs.mydesignsystem.components.menus.tokens.MyMenuTokenDefaults
import com.radhangs.mydesignsystem.theme.ExampleThemeLocal

/**
 * A composable function that creates a menu with customizable behavior and appearance.
 *
 * @param modifier A [Modifier] used to adjust the layout or behavior of the menu.
 * @param expanded A [Boolean] indicating whether the menu is expanded or not.
 * @param onDismissRequest A lambda function invoked when the menu is dismissed.
 * @param items A [List] of [MyMenuData] representing the items to be displayed in the menu.
 * @param selectedItemIndex An optional [Int] representing the index of the currently selected item. Defaults to `null`.
 * @param useSelectedCheckmark A [Boolean] indicating whether to show a checkmark for the selected item.
 * @param onItemPressed A lambda function invoked when an item is pressed, with the item's index and data as parameters.
 * @param offset A [DpOffset] used to adjust the position of the menu. Defaults to `DpOffset(0.dp, 0.dp)`.
 * @param defaultTokens An instance of [MyMenuTokenDefaults] that defines default styling and configuration for the menu.
 * Defaults to a [MyMenuTokenDefaults] instance with the current theme.
 */
@Composable
internal fun MyMenu(
    modifier: Modifier,
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    items: List<MyMenuData>,
    selectedItemIndex: Int?,
    useSelectedCheckmark: Boolean,
    onItemPressed: (Int, MyMenuItemData) -> Unit,
    offset: DpOffset = DpOffset(0.dp, 0.dp),
    defaultTokens: MyMenuTokenDefaults = MyMenuTokenDefaults(ExampleThemeLocal.theme)
) {
    MaterialTheme(
        shapes = MaterialTheme.shapes.copy(
            extraSmall = RoundedCornerShape(
                defaultTokens.dimensions.menuCornerRadius
            )
        )
    ) {
        val myMenuItemDataMap by remember(items) {
            derivedStateOf {
                items.mapIndexedNotNull { index, item ->
                    if (item is MyMenuItemData) {
                        index to item
                    } else {
                        null
                    }
                }
            }
        }

        val filteredItemFocusRequesters: Map<Int, FocusRequester> = myMenuItemDataMap.withIndex().associate {
            it.index to remember { FocusRequester() }
        }
        var focusedIndex: Int? by remember { mutableStateOf(null) }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = onDismissRequest,
            offset = offset,
            modifier = modifier
                .background(defaultTokens.colors.menuBackgroundColor)
                .onKeyEvent { keyEvent ->
                    if (keyEvent.nativeKeyEvent.keyCode == KeyEvent.KEYCODE_ESCAPE) {
                        // if escape key is pressed, dismiss the menu
                        onDismissRequest()
                        true
                    } else {
                        // when pressing a letter key, we'll focus the next item that starts with that letter
                        if (keyEvent.type == KeyEventType.KeyDown) {
                            keyEvent.utf16CodePoint.let { keyCode ->
                                if (keyCode in 'A'.code .. 'Z'.code || keyCode in 'a'.code .. 'z'.code) {
                                    val keyPressed = keyCode.toChar()
                                    val itemsWithStartingLetter = myMenuItemDataMap.mapIndexedNotNull { index, (_, item) ->
                                        if (item.enabled && item.text.startsWith(keyPressed, ignoreCase = true)) {
                                            index
                                        } else {
                                            null
                                        }
                                    }
                                    if (itemsWithStartingLetter.isNotEmpty()) {
                                        val nextFocusItem = if (focusedIndex != null) {
                                            itemsWithStartingLetter.firstOrNull { it > focusedIndex as Int }
                                        } else {
                                            null
                                        } ?: itemsWithStartingLetter.first()
                                        filteredItemFocusRequesters[nextFocusItem]?.requestFocus()
                                    }
                                    return@onKeyEvent true
                                }
                            }
                        }
                        false
                    }
                }
                .onFocusChanged {
                    if (!it.isFocused || !it.hasFocus) {
                        focusedIndex = null
                    }
                }
        ) {
            MyMenuItemList(
                modifier = Modifier.fillMaxWidth(),
                items = items,
                defaultTokens = defaultTokens.menuItemListDefaults,
                onItemPressed = onItemPressed,
                menuItemIndexFactory = { itemsIndex ->
                    myMenuItemDataMap.indexOfFirst { it.first == itemsIndex }
                },
                menuItemModifierFactory = { menuItemIndex ->
                    Modifier.run {
                        filteredItemFocusRequesters[menuItemIndex]?.let {
                            focusRequester(it)
                        } ?: this
                    }
                    .onFocusChanged {
                        if (it.isFocused) {
                            focusedIndex = menuItemIndex
                        }
                    }
                },
                selectedItemIndex = selectedItemIndex,
                useSelectedCheckmark = useSelectedCheckmark
            )
        }
    }
}