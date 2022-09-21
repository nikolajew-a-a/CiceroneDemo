package com.example.android.ciceronedemo.ui.simple

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android.ciceronedemo.R
import com.example.android.ciceronedemo.databinding.FragmentSimpleNavigationBinding

class SimpleNavigationFragment : Fragment(R.layout.fragment_simple_navigation) {
    private val viewBinding by viewBinding(FragmentSimpleNavigationBinding::bind)
    private val viewModel by viewModels<SimpleNavigationViewModel>()

    companion object {
        fun newInstance() = SimpleNavigationFragment()
    }

}