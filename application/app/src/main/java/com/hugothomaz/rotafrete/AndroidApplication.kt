package com.hugothomaz.rotafrete

import android.app.Application
import com.hugothomaz.data.di.dataModule
import com.hugothomaz.domain.di.domainModel
import com.hugothomaz.rotafrete.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@AndroidApplication)
            modules(appModule, dataModule, domainModel)
        }
    }

}