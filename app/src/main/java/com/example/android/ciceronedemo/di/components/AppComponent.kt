package com.example.android.ciceronedemo.di.components

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.android.ciceronedemo.di.viewmodel.VMModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [VMModel::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun applicationContext(context: Context): Builder
        fun build(): AppComponent
    }

    fun provideFactory(): ViewModelProvider.Factory
}