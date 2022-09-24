package com.example.android.ciceronedemo

import android.app.Application
import com.example.android.ciceronedemo.di.components.AppComponent
import com.example.android.ciceronedemo.di.components.DaggerAppComponent
import com.github.terrakok.cicerone.Cicerone

class App : Application() {

    val appComponent: AppComponent by lazy(
        DaggerAppComponent
            .builder()
            .applicationContext(this)::build
    )

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        internal lateinit var INSTANCE: App
            private set
    }
}