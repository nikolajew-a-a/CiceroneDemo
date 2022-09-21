package com.example.android.ciceronedemo.ui.selection

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android.ciceronedemo.R
import com.example.android.ciceronedemo.databinding.SelectionFragmentBinding

class SelectionFragment : Fragment(R.layout.selection_fragment) {

    private val viewBinding by viewBinding(SelectionFragmentBinding::bind)
    private lateinit var viewModel: SelectionViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[SelectionViewModel::class.java]

        bindViews()
        initButtons()
    }

    private fun bindViews() {}

    private fun initButtons() {}

    companion object {

        fun newInstance() = SelectionFragment()
    }

}