package com.radhangs.exampledesignsystem

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.radhangs.mydesignsystem.buttons.MyIconButton
import com.radhangs.mydesignsystem.buttons.MyTextButton
import com.radhangs.mydesignsystem.icons.DesignSystemIcons
import com.radhangs.mydesignsystem.theme.ExampleTheme

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
