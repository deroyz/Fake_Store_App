package kim.young.fakestoreapp.shared.data.local

import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.notifications.ResultsChange
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow

interface AbstractRealmService {
    fun getAllProducts(): Flow<ResultsChange<ProductDatabaseModel>>
    fun insertProductList(products: List<ProductDatabaseModel>)
}

class RealmService(private val realm: Realm) : AbstractRealmService {

    override fun getAllProducts() = realm.query<ProductDatabaseModel>().find().asFlow()


    override fun insertProductList(products: List<ProductDatabaseModel>) {
        CoroutineScope(Dispatchers.Default).async {
            products.forEach { product ->
                realm.write {
                    copyToRealm(
                        product
                    )
                }
            }
        }
    }
}
