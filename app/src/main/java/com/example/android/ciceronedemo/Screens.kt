package com.example.android.ciceronedemo

import com.example.android.ciceronedemo.ui.simple.SimpleNavigationArgs
import com.example.android.ciceronedemo.ui.simple.SimpleNavigationFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun SimpleNavigationFragment(args: SimpleNavigationArgs) = FragmentScreen { SimpleNavigationFragment.newInstance(args) }
}