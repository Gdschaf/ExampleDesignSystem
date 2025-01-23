package com.radhangs.exampledesignsystem

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.radhangs.mydesignsystem.components.cards.MyVerticalCard
import com.radhangs.mydesignsystem.theme.ExampleTheme
import com.radhangs.mydesignsystem.util.MyUrlMedia

@Composable
internal fun HomeScreen(
    modifier: Modifier
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(count = 2)
    ) {
        items(homeScreenItems) { item ->
            MyVerticalCard(
                modifier = Modifier.width(70.dp),
                title = item.itemTitle,
                cardMedia = MyUrlMedia("")
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    ExampleTheme {
        HomeScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}