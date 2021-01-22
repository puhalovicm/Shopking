package hr.fer.objobl.shopking.application

import android.app.Application
import hr.fer.objobl.shopking.module.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ShopkingApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ShopkingApplication)
            modules(
                listOf(
                    applicationModule
                )
            )
        }
    }
}
