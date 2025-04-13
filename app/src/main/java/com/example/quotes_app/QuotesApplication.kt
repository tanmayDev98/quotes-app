package com.example.quotes_app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//class QuotesApplication : Application() {
//    lateinit var container: AppContainer
//
//    override fun onCreate() {
//        super.onCreate()
//        container = AppContainerImpl(this)
//    }
//}

@HiltAndroidApp
class QuotesApplication : Application()