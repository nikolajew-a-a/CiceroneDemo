package com.example.android.ciceronedemo

import com.example.android.ciceronedemo.ui.simple.SimpleNavigationArgs
import com.example.android.ciceronedemo.ui.simple.SimpleNavigationFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun SelectionFragment() = FragmentScreen { com.example.android.ciceronedemo.ui.selection.SelectionFragment.newInstance() }

    fun SimpleNavigationFragment(number: Int = 0) =
        FragmentScreen { SimpleNavigationFragment.newInstance(SimpleNavigationArgs(number = number, time = System.currentTimeMillis())) }
}