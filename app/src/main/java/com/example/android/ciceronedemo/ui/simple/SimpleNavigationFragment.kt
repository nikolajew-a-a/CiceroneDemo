package com.example.android.ciceronedemo.ui.simple

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android.ciceronedemo.R
import com.example.android.ciceronedemo.databinding.FragmentSimpleNavigationBinding
import com.example.android.ciceronedemo.di.viewmodel.injectViewModel
import com.example.android.ciceronedemo.util.findArgument
import com.example.android.ciceronedemo.util.withArguments

class SimpleNavigationFragment : Fragment(R.layout.fragment_simple_navigation) {

    private val viewBinding by viewBinding(FragmentSimpleNavigationBinding::bind)
    private val viewModel: SimpleNavigationViewModel by injectViewModel()
    private val args: SimpleNavigationArgs by lazy { findArgument(ARGS_KEY)!! }

    companion object {

        private const val ARGS_KEY = "SimpleNavigationFragmentArgsKey"

        fun newInstance(args: SimpleNavigationArgs) = SimpleNavigationFragment().withArguments(ARGS_KEY to args)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initButtons()
    }

    private fun initViewModel() {
        viewModel.setUpArgs(args)
        viewModel.backStack.observe(viewLifecycleOwner, this@SimpleNavigationFragment::handleBackStack)
    }

    private fun handleBackStack(backStack: List<Int>) {
        viewBinding.backstackInformation.text = backStack.joinToString(" -> ")
    }

    private fun initButtons() = with(viewBinding) {
        forwardButton.setOnClickListener { viewModel.forwardAction() }
        backButon.setOnClickListener { viewModel.backAction() }
        replaceButton.setOnClickListener { viewModel.replaceAction() }
        forwardWithDelayButton.setOnClickListener { viewModel.forwardWithDelayAction() }
        newRootButton.setOnClickListener {  }
        backTo3Button.setOnClickListener {  }
        finishChainButton.setOnClickListener {  }
    }

}