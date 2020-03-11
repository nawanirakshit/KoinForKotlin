package com.rakshit.koinforkotlin.di

import com.rakshit.koinforkotlin.activity.LoginViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { LoginViewModel(get(), get()) }
}

