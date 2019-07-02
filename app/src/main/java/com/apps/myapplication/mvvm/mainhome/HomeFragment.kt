package com.apps.myapplication.mvvm.mainhome

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apps.myapplication.base.BaseFragment
import com.apps.myapplication.databinding.HomeFragmentBinding

class HomeFragment : BaseFragment(){
    private lateinit var viewBinding: HomeFragmentBinding
    private lateinit var mainAdapter: HomeAdapter
    private  lateinit var viewModel : HomeViewModel

    companion object {
        private val ARG_CAUGHT = "myFragment_caught"

        fun newInstance(caught: String) : HomeFragment{
            val args: Bundle = Bundle()
            Log.d("cekstring",""+caught)
            args.putSerializable(ARG_CAUGHT, caught)
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = HomeFragmentBinding.inflate(inflater, container, false)
        viewModel = HomeViewModel(activity?.applicationContext as Application, activity!!)
        viewBinding.viewModel = viewModel
        viewBinding.let {
            it.viewModel = viewBinding.viewModel
            it.setLifecycleOwner(this@HomeFragment)
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
        viewModel.start(category)

    }


    private fun setupNews() {
        val viewModel = viewBinding.viewModel

        if (viewModel != null) {
            mainAdapter = HomeAdapter(ArrayList(), activity!!, viewModel)

            viewBinding.recyclerviewMain.adapter = mainAdapter
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}