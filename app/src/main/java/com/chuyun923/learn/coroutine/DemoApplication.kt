package com.chuyun923.learn.coroutine

import android.app.Application
import kotlinx.coroutines.Dispatchers

class DemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        app = this
        Dispatchers.Default
    }

    companion object {

        lateinit var app: Application
    }
}
