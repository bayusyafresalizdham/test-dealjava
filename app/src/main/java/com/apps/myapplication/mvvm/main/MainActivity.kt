package com.apps.myapplication.mvvm.main

import android.os.Bundle
import com.apps.myapplication.R
import com.apps.myapplication.base.BaseActivity
import kotlinx.android.synthetic.main.main_activity.*


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val fragmentAdapter = TabAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter
        tabs_main.setupWithViewPager(viewpager_main)


    }



}