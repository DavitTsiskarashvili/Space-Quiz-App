package com

import android.app.Application
import com.data.module.dataBaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CommonApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@CommonApp)
            modules(
                dataBaseModule
            )
        }
    }
}