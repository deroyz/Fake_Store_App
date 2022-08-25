package kim.young.fakestoreapp.shared.di

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import kim.young.fakestoreapp.shared.data.local.AbstractRealmService
import kim.young.fakestoreapp.shared.data.local.ProductDatabaseModel
import kim.young.fakestoreapp.shared.data.local.RealmService
import kim.young.fakestoreapp.shared.data.remote.AbstractApiService
import kim.young.fakestoreapp.shared.data.remote.ApiService
import kim.young.fakestoreapp.shared.data.repository.AbstractRepository
import kim.young.fakestoreapp.shared.data.repository.Repository
import kim.young.fakestoreapp.shared.domain.usecase.CacheProductListFromApiUseCase
import kim.young.fakestoreapp.shared.domain.usecase.GetAllProductsFromRealmUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            repositoryModule,
            useCaseModule,
            dispatcherModule,
            platformModule()
        )
    }

// IOS
fun initKoin() = initKoin {}

val repositoryModule = module {

    // Http Client
    single {
        HttpClient {
            install(JsonFeature) {
                val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
                serializer = KotlinxSerializer(json)
            }
        }
    }

    // Realm Database (ProductDatabaseModel)
    single {
        val config = RealmConfiguration.Builder(schema = setOf(ProductDatabaseModel::class))
            .build()
        Realm.open(config)
    }

    // Data Structure Dependency /
    single<AbstractRealmService> {
        RealmService(get())
    }
    single<AbstractApiService> {
        ApiService(get())
    }
    single<AbstractRepository> {
        Repository(get(), get())
    }
}

val useCaseModule: Module = module {
    // Use Cases
    single {
        GetAllProductsFromRealmUseCase(get())
    }
    single {
        CacheProductListFromApiUseCase(get())
    }

}

val dispatcherModule = module {
    factory { Dispatchers.Default }
}
