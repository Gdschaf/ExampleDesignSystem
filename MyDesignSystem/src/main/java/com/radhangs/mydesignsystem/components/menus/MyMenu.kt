package com.radhangs.mydesignsystem.components.menus

import android.view.KeyEvent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
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