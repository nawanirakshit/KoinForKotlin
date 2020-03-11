package com.rakshit.koinforkotlin

import android.app.Application
import com.rakshit.koinforkotlin.di.*
import org.koin.android.ext.android.startKoin

/**
 * @author Rakshit Nawani
 */
class ApplicationClass : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(
            this, listOf(
                networkModule,
                apiModule,
                roomModule,
                viewModelModule,
                sharedPreferencesModule
            )
        )
    }
}