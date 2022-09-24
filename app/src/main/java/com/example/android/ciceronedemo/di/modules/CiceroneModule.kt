package com.example.android.ciceronedemo.di.modules

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CiceroneModule {
    private val cicerone: Cicerone<Router>  = Cicerone.create()

    @Singleton
    @Provides
    fun provideRouter(): Router = cicerone.router

    @Singleton
    @Provides
    fun provideNavigatorHolder(): NavigatorHolder = cicerone.getNavigatorHolder()
}