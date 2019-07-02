package com.apps.myapplication.mvvm.maindetail

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apps.myapplication.base.BaseFragment
import com.apps.myapplication.databinding.DetailFragmentBinding
import com.apps.myapplication.databinding.HomeFragmentBinding
import com.apps.myapplication.mvvm.mainhome.HomeAdapter
import com.apps.myapplication.mvvm.mainhome.HomeViewModel

class DetailFragment : BaseFragment(){

    private lateinit var viewBinding: DetailFragmentBinding
    private  lateinit var viewModel : DetailViewModel
    companion object {
        fun newInstance() = DetailFragment().apply {

        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = DetailFragmentBinding.inflate(inflater, container, false)
        viewModel = DetailViewModel(activity?.applicationContext as Application, activity!!)
        viewBinding.viewModel = viewModel

        viewBinding.let {
            it.viewModel = viewBinding.viewModel
            it.setLifecycleOwner(this@DetailFragment)
        }

        viewModel.start()
        return viewBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}