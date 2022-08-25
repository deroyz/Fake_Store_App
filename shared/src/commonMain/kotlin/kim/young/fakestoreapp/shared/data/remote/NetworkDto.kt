package kim.young.fakestoreapp.shared.data.remote

import kim.young.fakestoreapp.shared.data.local.ProductDatabaseModel
import kotlinx.serialization.Serializable

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
        fun getString(category: Category): String =
            when(category){
                Electronics  -> "electronics"
                Jewelery -> "jewelery"
                MenSClothing -> "men's clothing"
                WomenSClothing -> "women's clothing"
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
        it.id = this.id
        it.title = this.title
        it. price = this.price
        it.description = this.description
        it.category = Category.getString(this.category)
        it.image = this.image
        it.rate = this.rating.rate
        it.count = this.rating.count
    }
}

