package kim.young.fakestoreapp.shared.data.local

import io.realm.kotlin.types.RealmObject
import kim.young.fakestoreapp.shared.domain.ProductDomainModel

class ProductDatabaseModel: RealmObject {
    var id: Long = 0L
    var title: String = ""
    var price: Double = 0.0
    var description: String = ""
    var category: String = ""
    var image: String = ""
    var rate: Double = 0.0
    var count: Long = 0L
}

fun ProductDatabaseModel.asDomainModel() = ProductDomainModel(
    id,
    title,
    price,
    description,
    category,
    image,
    rate,
    count
)

fun List<ProductDatabaseModel>.asDomainModel(): List<ProductDomainModel>? {
    return map {
        it.asDomainModel()
    }
}
