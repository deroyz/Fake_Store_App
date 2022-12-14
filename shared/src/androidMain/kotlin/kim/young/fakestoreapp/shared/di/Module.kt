package kim.young.fakestoreapp.shared.di

import android.os.Parcelable
import io.ktor.client.engine.android.*
import kim.young.fakestoreapp.shared.MainDispatcher
import kotlinx.parcelize.Parcelize
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single { MainDispatcher() }
    single { Android.create() }
}

//actual typealias CommonParcelize = Parcelize
//actual typealias CommonParcelable = Parcelable

