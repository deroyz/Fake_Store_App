package kim.young.fakestoreapp.shared.domain.usecase

import kim.young.fakestoreapp.shared.data.repository.AbstractRepository
import kim.young.fakestoreapp.shared.domain.type.UseCase

class CacheProductListFromApiUseCase(
    private val repository: AbstractRepository
    ): UseCase() {

    override val block: suspend () -> Unit
        get() = { repository.cacheProductListFromApi() }

}
