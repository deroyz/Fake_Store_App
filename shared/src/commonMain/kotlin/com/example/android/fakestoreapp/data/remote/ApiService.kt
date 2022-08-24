package com.example.android.fakestoreapp.data.remote

import io.ktor.client.*
import io.ktor.client.request.*

interface AbstractApiService {
    suspend fun getProductsFromApi(): List<ProductNetworkModel>
}

class ApiService(
    private val httpClient: HttpClient
) : AbstractApiService {

    override suspend fun getProductsFromApi(): List<ProductNetworkModel> =
        httpClient.get<ProductApiResponse> { url(ApiRoutes.PRODUCT) }.results
}



