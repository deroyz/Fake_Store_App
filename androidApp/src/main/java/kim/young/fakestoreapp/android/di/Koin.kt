package kim.young.fakestoreapp.android.di

import kim.young.fakestoreapp.shared.features.products.ProductsViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { ProductsViewModel() }
//    single { DetailViewModel() }
}