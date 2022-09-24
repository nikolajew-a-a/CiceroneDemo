package com.example.android.ciceronedemo.di.components

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.android.ciceronedemo.MainActivity
import com.example.android.ciceronedemo.di.modules.CiceroneModule
import com.example.android.ciceronedemo.di.modules.VMModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [CiceroneModule::class, VMModel::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun applicationContext(context: Context): Builder
        fun build(): AppComponent
    }

    fun inject(activity: MainActivity)

    fun provideFactory(): ViewModelProvider.Factory
}