package com.radhangs.exampledesignsystem

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.radhangs.mydesignsystem.components.buttons.MyIconButton
import com.radhangs.mydesignsystem.components.buttons.MyTextButton
import com.radhangs.mydesignsystem.components.cards.MyHorizontalCard
import com.radhangs.mydesignsystem.components.cards.MyVerticalCard
import com.radhangs.mydesignsystem.components.menus.MyActionMenu
import com.radhangs.mydesignsystem.components.menus.MyMenuDivider
import com.radhangs.mydesignsystem.components.menus.MyMenuItemData
import com.radhangs.mydesignsystem.components.menus.MySelectionMenu
import com.radhangs.mydesignsystem.icons.DesignSystemIcons
import com.radhangs.mydesignsystem.theme.ExampleTheme
import com.radhangs.mydesignsystem.util.ASPECT_RATIO
import com.radhangs.mydesignsystem.util.MyDrawableMedia
import com.radhangs.mydesignsystem.util.MyIconMedia
import com.radhangs.mydesignsystem.util.MyUrlMedia

class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleTheme {
                HelloWorld()
            }
        }
    }
}

@Composable
private fun HelloWorld() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // This column is used to show the actual size of the component with the
        // minimum interactive size although visually it's not that big.
        Column(
            modifier = Modifier.background(Color.Green)
        ) {
            MyIconButton(
                designSystemIcon = DesignSystemIcons.Search,
                onButtonPressed = { Log.e("GARRETT", "Icon Button was pressed.") }
            )
        }

        MyTextButton(
            text = "Text Button",
            onButtonPressed = { Log.e("GARRETT", "Text Button was pressed.")}
        )

        MyTextButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Wide Text Button",
            onButtonPressed = { Log.e("GARRETT", "Text Button was pressed.")}
        )

        HelloWorldMenuButtons()

        MyVerticalCard(
            title = "Koenigsegg Jesko",
            cardMedia = MyUrlMedia(
                url = "https://moderncarcollector.com/wp-content/uploads/2024/06/Screen-Shot-2024-06-10-at-6.04.51-PM.png",
                aspectRatio = ASPECT_RATIO.RATIO_16_9
            )
        )

        MyHorizontalCard(
            title = "Koenigsegg Jesko",
            cardMedia = MyUrlMedia(
                url = "https://moderncarcollector.com/wp-content/uploads/2024/06/Screen-Shot-2024-06-10-at-6.04.51-PM.png",
                aspectRatio = ASPECT_RATIO.RATIO_1_1
            )
        )

        MyVerticalCard(
            title = "Good Doggo",
            cardMedia = MyDrawableMedia(
                drawableId = R.drawable.preview_image,
                aspectRatio = ASPECT_RATIO.RATIO_16_9
            )
        )

        MyHorizontalCard(
            title = "Good Doggo",
            cardMedia = MyDrawableMedia(
                drawableId = R.drawable.preview_image,
                aspectRatio = ASPECT_RATIO.RATIO_1_1
            )
        )

        MyVerticalCard(
            title = "Example Icon",
            cardMedia = MyIconMedia(
                icon = DesignSystemIcons.Menu,
                contentDescrambler = null,
                aspectRatio = ASPECT_RATIO.RATIO_16_9
            )
        )

        MyHorizontalCard(
            title = "Example Icon",
            cardMedia = MyIconMedia(
                icon = DesignSystemIcons.Menu,
                contentDescrambler = null,
                aspectRatio = ASPECT_RATIO.RATIO_1_1
            )
        )
    }
}

@Composable
private fun HelloWorldMenuButtons() {
    var actionMenuExpanded by remember { mutableStateOf(false) }
    val actionMenuButtonFocusRequester = remember { FocusRequester() }
    val onActionMenuClosed: () -> Unit = {
        actionMenuExpanded = false
        actionMenuButtonFocusRequester.requestFocus()
    }
    Box {
        MyIconButton(
            modifier = Modifier.focusRequester(actionMenuButtonFocusRequester),
            designSystemIcon = DesignSystemIcons.Menu,
            onButtonPressed = {
                Log.e("GARRETT", "Icon Button was pressed.")
                actionMenuExpanded = true
            }
        )

        MyActionMenu(
            expanded = actionMenuExpanded,
            items = listOf(
                MyMenuItemData(
                    text = "Example Item 1. This example has really long text to see how wide this thing goes and how it wraps.",
                    icon = DesignSystemIcons.Image.Outlined
                ),
                MyMenuItemData(
                    text = "Example Item 2",
                    icon = DesignSystemIcons.Image.Outlined
                ),
                MyMenuDivider,
                MyMenuItemData(
                    text = "Example Item 3",
                    icon = DesignSystemIcons.Image.Outlined
                ),
                MyMenuDivider,
                MyMenuItemData(
                    text = "Example Item 4",
                    icon = DesignSystemIcons.Image.Outlined
                )
            ),
            onDismissRequest = { onActionMenuClosed() },
            onItemPressed = { index, _ ->
                Log.e("GARRETT", "Menu Item $index was pressed.")
                onActionMenuClosed()
            }
        )
    }

    var selectionMenuExpanded by remember { mutableStateOf(false) }
    val selectionMenuButtonFocusRequester = remember { FocusRequester() }
    val onSelectionMenuClosed: () -> Unit = {
        selectionMenuExpanded = false
        selectionMenuButtonFocusRequester.requestFocus()
    }
    var selectionItemIndex: Int? by remember { mutableStateOf(null) }
    Box {
        MyIconButton(
            modifier = Modifier.focusRequester(selectionMenuButtonFocusRequester),
            designSystemIcon = DesignSystemIcons.Menu,
            onButtonPressed = {
                Log.e("GARRETT", "Icon Button was pressed.")
                selectionMenuExpanded = true
            }
        )

        MySelectionMenu(
            expanded = selectionMenuExpanded,
            items = listOf(
                MyMenuItemData(
                    text = "Example Item 1. This example has really long text to see how wide this thing goes and how it wraps.",
                    icon = DesignSystemIcons.Image.Outlined
                ),
                MyMenuItemData(
                    text = "Example Item 2",
                    icon = DesignSystemIcons.Image.Outlined
                ),
                MyMenuDivider,
                MyMenuItemData(
                    text = "Example Item 3",
                    icon = DesignSystemIcons.Image.Outlined
                ),
                MyMenuDivider,
                MyMenuItemData(
                    text = "Example Item 4",
                    icon = DesignSystemIcons.Image.Outlined
                )
            ),
            onDismissRequest = { onSelectionMenuClosed() },
            onItemPressed = { index, _ ->
                Log.e("GARRETT", "Menu Item $index was pressed.")
                selectionItemIndex = index
            },
            selectedItemIndex = selectionItemIndex,
            useSelectedCheckmark = true
        )
    }
}

// region preview

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Light Mode"
)
@Composable
private fun HelloWorldPreviewLight() {
    ExampleTheme {
        HelloWorld()
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Composable
private fun HelloWorldPreviewDark() {
    ExampleTheme {
        HelloWorld()
    }
}

// endregion
