package kim.young.fakestoreapp.shared.di

import android.os.Parcelable
import kim.young.fakestoreapp.shared.MainDispatcher
import kotlinx.parcelize.Parcelize
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single { MainDispatcher() }
}

actual typealias CommonParcelize = Parcelize
actual typealias CommonParcelable = Parcelable

