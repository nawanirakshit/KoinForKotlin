package com.rakshit.koinforkotlin.di

import com.rakshit.koinforkotlin.data.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val roomModule = module {
    single { AppDatabase.getInstance(androidApplication()) }
    single(createOnStart = false) { get<AppDatabase>().getMedicineDao() }
}