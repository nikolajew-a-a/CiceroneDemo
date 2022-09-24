package com.example.android.ciceronedemo.ui.simple

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.ciceronedemo.Screens
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SimpleNavigationViewModel @Inject constructor(private val router: Router): ViewModel() {
    private val _args = MutableLiveData<SimpleNavigationArgs>()
    val backStack = Transformations.map(_args) { args ->
        val currentFragment = (args.backStack.lastOrNull() ?: 0) + 1
        args.backStack.plus(currentFragment)
    }

    private val NAVIGATION_DELAY = 2500L
    private var navigationJob: Job? = null

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

    fun replaceAction() {
        val backStack = backStack.value ?: return
        val newArgs = SimpleNavigationArgs(backStack)
        router.replaceScreen(Screens.SimpleNavigationFragment(newArgs))
    }

    fun forwardWithDelayAction() {
        navigationJob?.cancel()
        navigationJob = viewModelScope.launch {
            delay(NAVIGATION_DELAY)
            val backStack = backStack.value ?: return@launch
            val newArgs = SimpleNavigationArgs(backStack)
            router.navigateTo(Screens.SimpleNavigationFragment(newArgs))
        }
    }
}