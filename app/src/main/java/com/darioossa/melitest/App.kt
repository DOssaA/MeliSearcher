package com.darioossa.melitest

import android.app.Application
import com.darioossa.melitest.data.Injection.dataModule
import com.darioossa.melitest.domain.Injection.domainModule
import com.darioossa.melitest.ui.Injection.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger(Level.ERROR)
            modules(listOf(presentationModule, domainModule, dataModule))
        }
    }
}