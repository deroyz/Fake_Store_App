package com.example.android.fakestoreapp.data.repository

import com.example.android.fakestoreapp.data.local.ProductDatabaseModel
import com.example.android.fakestoreapp.data.local.RealmService
import com.example.android.fakestoreapp.data.local.asDomainModel
import com.example.android.fakestoreapp.data.remote.ApiService
import com.example.android.fakestoreapp.data.remote.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collect

abstract class AbstractRepository {
    abstract suspend fun refreshProductListFromApi()
    abstract fun getAllProductsFromRealm(): Flow<List<ProductDatabaseModel>>
}

class Repository(
    private val ApiService: ApiService,
    private val RealmService: RealmService
) : AbstractRepository() {

    override suspend fun refreshProductListFromApi() {
        val products = ApiService.getProductsFromApi().asDatabaseModel()
        RealmService.insertProductList(products)
    }

    override fun getAllProductsFromRealm() = channelFlow<List<ProductDatabaseModel>> {

        RealmService.getAllProducts().collect() { resultsChange ->

            if (resultsChange.list.isEmpty()) {
                refreshProductListFromApi()
            } else {
                resultsChange.list.asDomainModel()
            }
        }
    }

}