package com.radhangs.exampledesignsystem

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
        MyIconButton(
            designSystemIcon = DesignSystemIcons.Search,
            onButtonPressed = { Log.e("GARRETT", "Icon Button was pressed.") }
        )

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

@Preview(showBackground = true, )
@Composable
private fun HelloWorldPreview() {
    ExampleTheme {
        HelloWorld()
    }
}