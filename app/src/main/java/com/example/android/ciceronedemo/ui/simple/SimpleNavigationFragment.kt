package com.example.android.ciceronedemo.ui.simple

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android.ciceronedemo.ui.base.BaseFragment
import com.example.android.ciceronedemo.R
import com.example.android.ciceronedemo.databinding.FragmentSimpleNavigationBinding
import com.example.android.ciceronedemo.di.viewmodel.injectViewModel
import com.example.android.ciceronedemo.util.findArgument
import com.example.android.ciceronedemo.util.withArguments

class SimpleNavigationFragment : BaseFragment(R.layout.fragment_simple_navigation) {

    private val viewBinding by viewBinding(FragmentSimpleNavigationBinding::bind)
    private val viewModel: SimpleNavigationViewModel by injectViewModel()

    private val args: SimpleNavigationArgs by lazy { findArgument(ARGS_KEY)!! }
    override val name: String by lazy { args.number.toString() }
    override val creationTime: Long by lazy { args.time }

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
    }

    private fun initButtons() = with(viewBinding) {
        forwardButton.setOnClickListener { viewModel.forwardAction() }
        backButon.setOnClickListener { viewModel.backAction() }
        replaceButton.setOnClickListener { viewModel.replaceAction() }
        forwardWithDelayButton.setOnClickListener { viewModel.forwardWithDelayAction() }
        newRootButton.setOnClickListener { viewModel.newRootAction() }
        backToSelectionButton.setOnClickListener { viewModel.backToSelectionAction() }
    }
}