package com.example.check24tech

import android.app.Application
import com.example.checkidenttask.data.di.appModule
import com.example.checkidenttask.data.di.databaseModule
import com.example.checkidenttask.data.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModule, useCaseModule, databaseModule)
        }
    }
}
