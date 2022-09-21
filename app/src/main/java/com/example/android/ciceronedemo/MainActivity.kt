package com.example.android.ciceronedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.ciceronedemo.ui.selection.SelectionFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SelectionFragment.newInstance())
                .commitNow()
        }
    }
}