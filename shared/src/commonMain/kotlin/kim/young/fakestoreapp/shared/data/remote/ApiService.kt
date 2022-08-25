package kim.young.fakestoreapp.shared.data.remote

import io.ktor.client.*
import io.ktor.client.request.*

interface AbstractApiService {
    suspend fun getProductsFromApi(): ProductApiResponse
}

class ApiService(
    private val httpClient: HttpClient
) : AbstractApiService {

    override suspend fun getProductsFromApi(): ProductApiResponse =
        httpClient.get { url(ApiRoutes.PRODUCT) }
}



