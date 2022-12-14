package kim.young.fakestoreapp.android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import kim.young.fakestoreapp.android.ui.features.detail.DetailScreen
import kim.young.fakestoreapp.android.ui.features.products.ProductsScreen
import kim.young.fakestoreapp.shared.domain.ProductDomainModel
import kim.young.fakestoreapp.shared.features.products.ProductsViewModel


@ExperimentalCoilApi
@Composable
fun Navigation(
    vmProducts: ProductsViewModel,
//    vmDetail: DetailViewModel
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = DestinationScreen.Products.route
    ) {
        composable(DestinationScreen.Products.route) {
            ProductsScreen(navController = navController, vm = vmProducts)
        }

//        composable(DestinationScreen.Detail.route) {
//            val productData =
//                navController.previousBackStackEntry?.arguments?.getParcelable<ProductDomainModel>("product")
//            productData?.let{
//                DetailScreen(navController = navController, product = productData)
//            }
//        }

    }

}

sealed class DestinationScreen(val route: String) {
    object Products : DestinationScreen("products")
    object Detail : DestinationScreen("detail")
}
