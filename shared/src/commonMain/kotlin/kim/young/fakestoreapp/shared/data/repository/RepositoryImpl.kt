package kim.young.fakestoreapp.shared.data.repository

import io.github.aakira.napier.Napier
import kim.young.fakestoreapp.shared.data.local.AbstractRealmService
import kim.young.fakestoreapp.shared.data.local.asDomainModel
import kim.young.fakestoreapp.shared.data.remote.AbstractApiService
import kim.young.fakestoreapp.shared.data.remote.asDatabaseModel
import kim.young.fakestoreapp.shared.domain.ProductDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow

abstract class AbstractRepository {
    abstract suspend fun cacheProductListFromApi()
    abstract fun getAllProductsFromRealm(): Flow<List<ProductDomainModel>>
}

class RepositoryImpl(
    private val ApiService: AbstractApiService,
    private val RealmService: AbstractRealmService
) : AbstractRepository() {

    override suspend fun cacheProductListFromApi() {
        val products = ApiService.getProductsFromApi().asDatabaseModel()
        RealmService.insertProductList(products)
        Napier.e{"hi2"}

    }

    override fun getAllProductsFromRealm(): Flow<List<ProductDomainModel>> {
        return channelFlow<List<ProductDomainModel>> {
            RealmService.getAllProducts().collect() { resultsChange ->
                resultsChange.list.asDomainModel()
            }
        }
    }

}

