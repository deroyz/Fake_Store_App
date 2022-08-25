package kim.young.fakestoreapp.shared.features.products

import kim.young.fakestoreapp.shared.domain.ProductDomainModel
import kim.young.fakestoreapp.shared.features.BasicUiState
import kim.young.fakestoreapp.shared.features.UiEvent
import kim.young.fakestoreapp.shared.features.UiState

interface ProductsContract {

    sealed interface  Event: UiEvent {
        object OnGetProducts: Event
        object OnRefresh: Event
    }

    data class State(
        val products: BasicUiState<List<ProductDomainModel>>
    ): UiState

}