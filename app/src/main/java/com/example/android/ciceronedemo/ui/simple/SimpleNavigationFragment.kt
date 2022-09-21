package com.example.android.ciceronedemo.ui.simple

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android.ciceronedemo.R
import com.example.android.ciceronedemo.databinding.FragmentSimpleNavigationBinding
import com.example.android.ciceronedemo.di.viewmodel.injectViewModel

class SimpleNavigationFragment : Fragment(R.layout.fragment_simple_navigation) {

    private val viewBinding by viewBinding(FragmentSimpleNavigationBinding::bind)
    private val viewModel: SimpleNavigationViewModel by injectViewModel()
    private val args by lazy { requireArguments().getParcelable(ARGS_KEY, SimpleNavigationArgs::class.java) }

    companion object {

        private const val ARGS_KEY = "SimpleNavigationFragmentArgsKey"

        fun newInstance(args: SimpleNavigationArgs = SimpleNavigationArgs(emptyList())) = SimpleNavigationFragment().apply {
            arguments?.putParcelable(ARGS_KEY, args)
        }
    }

}