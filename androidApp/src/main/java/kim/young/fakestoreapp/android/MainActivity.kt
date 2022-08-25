package kim.young.fakestoreapp.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface

import kim.young.fakestoreapp.android.theme.FakeStoreAppTheme
import kim.young.fakestoreapp.android.ui.navigation.Navigation
import kim.young.fakestoreapp.shared.IExecutorScope
import kim.young.fakestoreapp.shared.features.products.ProductsViewModel
import org.koin.android.ext.android.inject

class MainActivity : kim.young.fakestoreapp.android.BaseActivity() {

    private val vmProducts: ProductsViewModel by inject()
//    private val vmDetail: DetailViewModel by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FakeStoreAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Navigation(
                        vmProducts = vmProducts
//                        vmDetail = vmDetail
                    )
                }
            }
        }
    }

    override val vm: Array<IExecutorScope>
        get() = arrayOf(vmProducts)

}
