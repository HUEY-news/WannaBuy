package com.houston.buy.app

import android.app.Application
import com.houston.buy.di.dataModule
import com.houston.buy.di.interactorModule
import com.houston.buy.di.repositoryModule
import com.houston.buy.di.viewModelModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(viewModelModule, interactorModule, repositoryModule, dataModule)
        }
    }
}
