package com.example.android.ciceronedemo.ui.selection

import androidx.lifecycle.ViewModel
import com.example.android.ciceronedemo.Screens
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class SelectionViewModel @Inject constructor(private val router: Router): ViewModel() {

    fun toSimpleNavigation() {
        router.navigateTo(Screens.SimpleNavigationFragment())
    }
}