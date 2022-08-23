package com.example.android.fakestoreapp.di

import com.example.android.fakestoreapp.platformModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module


fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin{
        appDeclaration()
        modules(commonModule(), platformModule())
    }

fun commonModule() = module {

}
