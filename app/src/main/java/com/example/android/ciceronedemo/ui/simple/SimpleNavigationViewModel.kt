package com.example.android.ciceronedemo.ui.simple

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.android.ciceronedemo.Screens
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class SimpleNavigationViewModel @Inject constructor(private val router: Router): ViewModel() {
    private val _args = MutableLiveData<SimpleNavigationArgs>()
    val backStack = Transformations.map(_args) { args ->
        val currentFragment = (args.backStack.lastOrNull() ?: 0) + 1
        args.backStack.plus(currentFragment)
    }

    fun setUpArgs(args: SimpleNavigationArgs) {
        _args.value = args
    }

    fun forwardAction() {
        val backStack = backStack.value ?: return
        val newArgs = SimpleNavigationArgs(backStack)
        router.navigateTo(Screens.SimpleNavigationFragment(newArgs))
    }

    fun backAction() {
        router.exit()
    }
}