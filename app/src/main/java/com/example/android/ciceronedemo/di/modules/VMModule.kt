package com.example.android.ciceronedemo.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.ciceronedemo.di.viewmodel.ViewModelFactory
import com.example.android.ciceronedemo.di.viewmodel.ViewModelKey
import com.example.android.ciceronedemo.ui.selection.SelectionViewModel
import com.example.android.ciceronedemo.ui.simple.SimpleNavigationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface VMModel {
    @Binds
    @IntoMap
    @ViewModelKey(SimpleNavigationViewModel::class)
    fun simpleNavigationViewModel(viewModel: SimpleNavigationViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SelectionViewModel::class)
    fun selectionViewModel(viewModel: SelectionViewModel): ViewModel

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}