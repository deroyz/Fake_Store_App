package kim.young.fakestoreapp.android

import android.app.Application
import kim.young.fakestoreapp.android.di.viewModelModule
import kim.young.fakestoreapp.shared.di.initKoin
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class FakeStoreApp: Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@FakeStoreApp)
            modules(
                viewModelModule
            )
        }

    }
}