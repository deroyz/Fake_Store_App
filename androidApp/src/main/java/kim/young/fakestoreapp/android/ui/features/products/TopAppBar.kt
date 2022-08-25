package kim.young.fakestoreapp.android.ui.features.products

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable

@Composable
fun ActionBar(
    actionFavorite: () -> Unit
) {
    TopAppBar(
        title = { Text(text = "Rick & Morty KMM") },
        actions = {
            ActionBarIcon(
                onClick = actionFavorite,
                icon = Icons.Filled.Favorite
            )
        }
    )
}