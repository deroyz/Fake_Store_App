package com.example.android.fakestoreapp.di

import com.example.android.fakestoreapp.data.local.AbstractRealmService
import com.example.android.fakestoreapp.data.local.ProductDatabaseModel
import com.example.android.fakestoreapp.data.local.RealmService
import com.example.android.fakestoreapp.data.remote.AbstractApiService
import com.example.android.fakestoreapp.data.remote.ApiService
import com.example.android.fakestoreapp.data.repository.AbstractRepository
import com.example.android.fakestoreapp.data.repository.Repository
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            repositoryModule,
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
        Realm.open(
            RealmConfiguration.Builder(schema = setOf(ProductDatabaseModel::class))
                .build()
        )
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

//    // Use Cases
//    single {
//        GetScientistsByOriginUseCase(get())
//    }
//    single {
//        GetAllScientistUseCase(get())
//    }

}