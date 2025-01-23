package com.radhangs.mydesignsystem.components.menus

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import com.radhangs.mydesignsystem.components.MyDivider
import com.radhangs.mydesignsystem.components.menus.tokens.MyMenuItemListTokenDefaults
import com.radhangs.mydesignsystem.icons.DesignSystemIcon
import com.radhangs.mydesignsystem.icons.DesignSystemIcons
import com.radhangs.mydesignsystem.theme.ExampleTheme
import com.radhangs.mydesignsystem.theme.ExampleThemeLocal
import com.radhangs.mydesignsystem.util.DarkModePreview
import com.radhangs.mydesignsystem.util.LightModePreview
import com.radhangs.mydesignsystem.util.verticalCollectionInfo
import com.radhangs.mydesignsystem.util.verticalCollectionItemInfo

/**
 * List of [MyMenuItem] that is displayed using a list of [MyMenuData] that defines the items and dividers.
 * This is marked internal because only other components inside the design system should use this.
 * for example, obviously menus, but also things like bottom sheets or dialogs that want to display
 * a list of menu items as their content.
 * So this doesn't have anything menu specific in it, for that, see [MyMenu] which further builds on this
 * but in a more menu context.
 *
 * @param modifier The modifier to apply to the [LazyColumn] that houses the content
 * @param items The list of [MyMenuData] that defines the items and dividers.
 * @param defaultTokens The default tokens to use for the [MyMenuItem] and [MyDivider] components in the list
 * among some other visual spacing tokens for the list itself.
 * See [MyMenuItemListTokenDefaults] for more information.
 * @param onItemPressed The callback to be invoked when an item is pressed, as defined by a [MyMenuItemData].
 * The first parameter is the index of the [MyMenuItemData] in the list, the second is the item itself.
 * if null, the items will not be interactive.
 * @param menuItemModifierFactory A factory function used to create a modifier for the [MyMenuItem]
 * component. The parameter is the index of the item in the list which then can be used to create a item
 * specific modifier.
 * @param selectedItemIndex The index of the selected item in the list. If null, no item is selected.
 * @param useSelectedCheckmark The option to use a checkmark icon to indicate the selected item. It false,
 * this will use just the background color to indicate selection. If true, this won't display the
 * icon defined in the [MyMenuItemData] on the [MyMenuItem] component.
 */
@Composable
internal fun MyMenuItemList(
    modifier: Modifier,
    items: List<MyMenuData>,
    defaultTokens: MyMenuItemListTokenDefaults,
    onItemPressed: ((Int, MyMenuItemData) -> Unit)? = null,
    menuItemIndexFactory: (Int) -> Int = { it },
    menuItemModifierFactory: (Int) -> Modifier = { Modifier },
    selectedItemIndex: Int? = null,
    useSelectedCheckmark: Boolean = false
) {
    val myMenuItemDataCount = items.filterIsInstance<MyMenuItemData>().count()
    // TODO try a lazy column again, however I do believe this is cause issues with my focus requester stuff when pressing a key
    // I know that the lazy column has a bring item into view part of the lazy list state, I wonder if I could use that
    // rather then focus requesters. Something to dig into
    Column(
        modifier = modifier.verticalCollectionInfo(myMenuItemDataCount)
    ) {
        items.forEachIndexed { index, item ->
            when (item) {
                is MyMenuItemData -> {
                    val itemIndex = menuItemIndexFactory(index)
                    val menuItemIcon = if (!useSelectedCheckmark) {
                        item.icon
                    } else {
                        if (selectedItemIndex == itemIndex) {
                            DesignSystemIcons.Check
                        } else {
                            null
                        }
                    }
                    MyMenuItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .verticalCollectionItemInfo(itemIndex)
                            .semantics { if (itemIndex == 0) traversalIndex = -1F }
                            .padding(vertical = defaultTokens.dimensions.menuItemVerticalPadding)
                            .then(menuItemModifierFactory(itemIndex)),
                        text = item.text,
                        icon = menuItemIcon,
                        enabled = item.enabled,
                        onItemPressed = onItemPressed?.let {
                            {
                                onItemPressed(itemIndex, item)
                            }
                        },
                        selected = selectedItemIndex == itemIndex,
                        defaultTokens = defaultTokens.menuItemDefaultTokens
                    )
                }
                is MyMenuDivider -> {
                    MyDivider(
                        modifier = Modifier.padding(vertical = defaultTokens.dimensions.dividerVerticalPadding),
                        defaultTokens = defaultTokens.dividerDefaults
                    )
                }
            }
        }
    }
}

public sealed interface MyMenuData

public data object MyMenuDivider: MyMenuData

public data class MyMenuItemData(
    val text: String,
    val enabled: Boolean = true,
    val icon: DesignSystemIcon? = null
): MyMenuData

// region Preview

@Composable
@LightModePreview
@DarkModePreview
private fun MyMenuItemListPreview() {
    ExampleTheme {
        MyMenuItemList(
            modifier = Modifier.fillMaxWidth(),
            items = listOf(
                MyMenuItemData(
                    text = "Example Item 1"
                ),
                MyMenuItemData(
                    text = "Example Item 2"
                ),
                MyMenuDivider,
                MyMenuItemData(
                    text = "Example Item 3"
                ),
                MyMenuDivider,
                MyMenuItemData(
                    text = "Example Item 4"
                )
            ),
            defaultTokens = MyMenuItemListTokenDefaults(ExampleThemeLocal.theme)
        )
    }
}

// endregion
