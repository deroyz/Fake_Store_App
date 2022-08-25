package kim.young.fakestoreapp.shared.features.products

import io.github.aakira.napier.Napier
import kim.young.fakestoreapp.shared.Resource
import kim.young.fakestoreapp.shared.domain.usecase.CacheProductListFromApiUseCase
import kim.young.fakestoreapp.shared.domain.usecase.GetAllProductsFromRealmUseCase
import kim.young.fakestoreapp.shared.features.BaseViewModel
import kim.young.fakestoreapp.shared.features.BasicUiState
import kim.young.fakestoreapp.shared.features.UiEffect
import org.koin.core.component.inject

open class ProductsViewModel :
    BaseViewModel<ProductsContract.Event, ProductsContract.State, UiEffect>() {

    private val cacheProductListFromApiUseCase: CacheProductListFromApiUseCase by inject()
    private val getAllProductsFromRealmUseCase: GetAllProductsFromRealmUseCase by inject()

    init {
        Napier.e{"hi"}
        cacheProductList()
        getProducts()
    }

    private fun getProducts() {
        setState { copy(products = BasicUiState.Loading)}
        collect(getAllProductsFromRealmUseCase()) { resourceProducts ->
            when(resourceProducts){
                is Resource.Error -> setState { copy(products = BasicUiState.Error()) }
                is Resource.Success -> setState {
                    copy(
                        products = if (resourceProducts.data.isEmpty())
                            BasicUiState.Empty
                        else
                            BasicUiState.Success(resourceProducts.data)
                    )
                }
            }
        }
    }

    private fun cacheProductList() {
        cacheProductListFromApiUseCase.invoke()
    }


    override fun createInitialState(): ProductsContract.State =
        ProductsContract.State(products = BasicUiState.Idle)

    override fun handleEvent(event: ProductsContract.Event) {
        when (event) {
            ProductsContract.Event.OnGetProducts -> getProducts()
            ProductsContract.Event.OnRefresh -> cacheProductList()
        }
    }

}