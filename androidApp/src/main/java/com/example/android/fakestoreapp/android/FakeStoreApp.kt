package com.example.android.fakestoreapp.android

import android.app.Application
import com.example.android.fakestoreapp.di.initKoin

class FakeStoreApp: Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin{

        }
    }
}