package com.example.android.ciceronedemo.ui.main

import android.hardware.SensorEventListener
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.ciceronedemo.R


class MainFragment : Fragment() {
    private lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        bindViews()
        initButtons()
    }


    private fun bindViews() {}

    private fun initButtons() {}

    companion object {
        fun newInstance() = MainFragment()
    }

}