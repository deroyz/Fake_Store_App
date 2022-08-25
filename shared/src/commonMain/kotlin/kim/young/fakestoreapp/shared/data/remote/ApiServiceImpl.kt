package kim.young.fakestoreapp.shared.data.remote

import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*

interface AbstractApiService {
    suspend fun getProductsFromApi(): List<ProductNetworkModel>
}

class ApiServiceImpl(
    private val path: String,
    private val httpClient: HttpClient
) : AbstractApiService {

    override suspend fun getProductsFromApi(): List<ProductNetworkModel> {
        Napier.e{"hi3"}
        return httpClient.get(path)
    }


//    private fun HttpRequestBuilder.apiUrl(path: String) {
//        url {
//            takeFrom(endPoint)
//            encodedPath = path
//        }
//    }
}



