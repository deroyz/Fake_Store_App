package kim.young.fakestoreapp.shared.domain.usecase

import kim.young.fakestoreapp.shared.data.repository.AbstractRepository
import kim.young.fakestoreapp.shared.domain.ProductDomainModel
import kim.young.fakestoreapp.shared.domain.type.UseCaseOutFlow
import kotlinx.coroutines.flow.Flow


class GetAllProductsFromRealmUseCase(
    private val repository: AbstractRepository
): UseCaseOutFlow<List<ProductDomainModel>>() {

    override fun build(): Flow<List<ProductDomainModel>> = repository.getAllProductsFromRealm()
}


