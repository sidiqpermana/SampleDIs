package com.nbs.sampledidip

import android.app.Application
import com.nbs.sampledidip.di.databaseModule
import com.nbs.sampledidip.di.personFeatureModule
import com.nbs.sampledidip.di.rxModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SampleDiDipApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SampleDiDipApplication)
            modules(
                listOf(
                    databaseModule,
                    rxModule,
                    personFeatureModule
                )
            )
        }
    }
}