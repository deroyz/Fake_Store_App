package kim.young.fakestoreapp.shared.domain

import kim.young.fakestoreapp.shared.di.CommonParcelable
import kim.young.fakestoreapp.shared.di.CommonParcelize


@CommonParcelize
data class ProductDomainModel(
    val id: Long? = 0L,
    val title: String? = "",
    val price: Double? = 0.0,
    val description: String? = "",
    val category: String? = "",
    val image: String? = "",
    val rate: Double? = 0.0,
    var count: Long? = 0L,

) : CommonParcelable {
    constructor(): this(
        id = 0,
        title = "",
        price = 0.0,
        description = "",
        category = "",
        image = "",
        rate = 0.0,
        count = 0,
    )
}