package com.rakshit.koinforkotlin.di

import com.rakshit.koinforkotlin.io.RequestAPIs
import org.koin.dsl.module.module
import retrofit2.Retrofit

val apiModule = module {
    single(createOnStart = false) { get<Retrofit>().create(RequestAPIs::class.java) }
}