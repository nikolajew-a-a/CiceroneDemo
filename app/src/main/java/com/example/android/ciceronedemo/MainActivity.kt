package com.example.android.ciceronedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android.ciceronedemo.databinding.MainActivityBinding
import com.example.android.ciceronedemo.ui.selection.SelectionFragment
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import java.lang.ref.WeakReference
import java.util.ArrayList
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ChainHolder {
    private val viewBinding by viewBinding(MainActivityBinding::bind)

    override val chain = ArrayList<WeakReference<Fragment>>()

    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    private val navigator: Navigator = object : AppNavigator(this, R.id.container) {
        override fun applyCommands(commands: Array<out Command>) {
            super.applyCommands(commands)
            supportFragmentManager.executePendingTransactions()
            printBackstackState()
        }
    }


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

    private fun printBackstackState() {
        val fragments = ArrayList<ChainScreen>()
        for (fragmentReference in chain) {
            val fragment = fragmentReference.get()
            if (fragment != null && fragment is ChainScreen) {
                fragments.add(fragment)
            }
        }
        fragments.sortWith { f1, f2 ->
            val t = f1.creationTime - f2.creationTime
            if (t > 0) 1 else if (t < 0) -1 else 0
        }
        val keys = ArrayList<String>()
        for (fragment in fragments) {
            keys.add(fragment.name)
        }
        viewBinding.backstackState.text = "Chain: $keys"
    }
}