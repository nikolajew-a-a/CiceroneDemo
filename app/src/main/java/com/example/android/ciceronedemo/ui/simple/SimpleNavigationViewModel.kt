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
    private var args: SimpleNavigationArgs? = null

    private val NAVIGATION_DELAY = 2500L
    private var navigationJob: Job? = null

    fun setUpArgs(args: SimpleNavigationArgs) {
        this.args = args
    }

    fun forwardAction() {
        val nextNumber = (args?.number?.plus(1)) ?: return
        router.navigateTo(Screens.SimpleNavigationFragment(nextNumber))
    }

    fun backAction() {
        router.exit()
    }

    fun replaceAction() {
        val nextNumber = (args?.number?.plus(1)) ?: return
        router.replaceScreen(Screens.SimpleNavigationFragment(nextNumber))
    }

    fun forwardWithDelayAction() {
        navigationJob?.cancel()
        navigationJob = viewModelScope.launch {
            delay(NAVIGATION_DELAY)
            val nextNumber = (args?.number?.plus(1)) ?: return@launch
            router.navigateTo(Screens.SimpleNavigationFragment(nextNumber))
        }
    }
}