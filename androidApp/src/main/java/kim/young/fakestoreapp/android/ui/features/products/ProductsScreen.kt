package kim.young.fakestoreapp.android.ui.features.products

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import kim.young.fakestoreapp.android.ui.features.products.state.ManagementResourceState
import kim.young.fakestoreapp.shared.domain.ProductDomainModel
import kim.young.fakestoreapp.shared.features.products.ProductsContract
import kim.young.fakestoreapp.shared.features.products.ProductsViewModel

@ExperimentalCoilApi
@Composable
fun ProductsScreen(
//    onProductClick: (Long) -> Unit,
    navController: NavController,
    vm: ProductsViewModel
) {
    val state by vm.uiState.collectAsState()

    Scaffold { padding ->
        TopAppBar(
        title = { Text(text = "Fake Store App") }
    )
        Log.e("ProductsScreen", "${vm}")

        ManagementResourceState(
            resourceState = state.products,
            successView = { products ->
                checkNotNull(products)
                ProductList(
                    products = products,
//                    onProductClick = onProductClick
                )
            },

            modifier = Modifier.padding(padding),
            onTryAgain = { vm.setEvent(ProductsContract.Event.OnGetProducts) },
            onCheckAgain = { vm.setEvent(ProductsContract.Event.OnGetProducts) },
        )
    }
}

@ExperimentalCoilApi
@Composable
fun ProductList(
    products: List<ProductDomainModel>,
//    onProductClick: (Long) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        items(products) { product ->
            ProductItem(
                product = product,
//                onClick = { product.id?.let { onProductClick(it) } }
            )
        }
    }
}
