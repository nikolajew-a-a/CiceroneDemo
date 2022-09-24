package com.example.android.ciceronedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.ciceronedemo.ui.selection.SelectionFragment
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    private val navigator = AppNavigator(this, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.INSTANCE.appComponent.inject(this)
        setContentView(R.layout.main_activity)

        //TODO (replace with Cicerone)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SelectionFragment.newInstance())
                .commitNow()
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}