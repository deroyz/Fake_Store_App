package com.example.android.fakestoreapp.data.remote

import com.example.android.fakestoreapp.data.local.ProductDatabaseModel
import kotlinx.serialization.Serializable

@Serializable
data class ProductApiResponse(
    val results: List<ProductNetworkModel>
)

@Serializable
data class ProductNetworkModel(
    val id: Long,
    val title: String,
    val price: Double,
    val description: String,
    val category: Category,
    val image: String,
    val rating: Rating
)

@Serializable
enum class Category(val value: String) {
    Electronics("electronics"),
    Jewelery("jewelery"),
    MenSClothing("men's clothing"),
    WomenSClothing("women's clothing");

    companion object {
        public fun getValue(value: String): Category = when (value) {
            "electronics" -> Electronics
            "jewelery" -> Jewelery
            "men's clothing" -> MenSClothing
            "women's clothing" -> WomenSClothing
            else -> throw IllegalArgumentException()
        }
    }
}

@Serializable
data class Rating(
    val rate: Double,
    val count: Long
)

fun List<ProductNetworkModel>.asDatabaseModel() = map { it.asDatabaseModel()}

fun ProductNetworkModel.asDatabaseModel(): ProductDatabaseModel {
    return ProductDatabaseModel().also{
        it.id = this.id!!
        it.title = this.title
        it. price = this.price
        it.description = this.description
        it.category = this.category.value
        it.image = this.image
        it.rate = this.rating.rate
        it.count = this.rating.count
    }
}