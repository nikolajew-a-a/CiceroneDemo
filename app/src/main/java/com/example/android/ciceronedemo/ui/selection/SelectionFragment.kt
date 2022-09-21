package com.example.android.ciceronedemo.ui.selection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android.ciceronedemo.R
import com.example.android.ciceronedemo.databinding.SelectionFragmentBinding
import com.example.android.ciceronedemo.ui.simple.SimpleNavigationFragment
import com.example.android.ciceronedemo.util.showToast

class SelectionFragment : Fragment(R.layout.selection_fragment) {

    private val viewBinding by viewBinding(SelectionFragmentBinding::bind)
    private val viewModel by viewModels<SelectionViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews()
        initButtons()
    }

    private fun bindViews() {}

    private fun initButtons() = with(viewBinding) {
        simpleNavigationButton.setOnClickListener {
            activity?.supportFragmentManager?.commit {
                replace<SimpleNavigationFragment>(R.id.container)
                addToBackStack(null)
            }
        }
        notImplementedButton.setOnClickListener {
            showToast("Not implemented yet")
        }
    }

    companion object {
        fun newInstance() = SelectionFragment()
    }

}