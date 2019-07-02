package com.apps.myapplication.mvvm.mainpinjaman

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apps.myapplication.base.BaseFragment
import com.apps.myapplication.databinding.HomeFragmentBinding
import com.apps.myapplication.databinding.PinjamanFragmentBinding

class PinjamanFragment : BaseFragment(){
    private lateinit var viewBinding: PinjamanFragmentBinding
    private lateinit var mainAdapter: PinjamanAdapter
    private  lateinit var viewModel : PinjamanViewModel

    companion object {
        private val ARG_CAUGHT = "myFragment_caught"

        fun newInstance(caught: String) : PinjamanFragment{
            val args: Bundle = Bundle()
            Log.d("cekstring",""+caught)
            args.putSerializable(ARG_CAUGHT, caught)
            val fragment = PinjamanFragment()
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = PinjamanFragmentBinding.inflate(inflater, container, false)
        viewModel = PinjamanViewModel(activity?.applicationContext as Application, activity!!)
        viewBinding.viewModel = viewModel
        viewBinding.let {
            it.viewModel = viewBinding.viewModel
            it.setLifecycleOwner(this@PinjamanFragment)
        }

        return viewBinding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupNews()
    }


    override fun onResume() {
        super.onResume()
        var category = arguments?.getSerializable(ARG_CAUGHT) as String
        Log.d("cekindex",""+category);
        viewModel.start()

    }


    private fun setupNews() {
        val viewModel = viewBinding.viewModel

        if (viewModel != null) {
            mainAdapter = PinjamanAdapter(ArrayList(), activity!!, viewModel)

            viewBinding.recyclerviewMain.adapter = mainAdapter
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}