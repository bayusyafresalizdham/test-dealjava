package com.apps.myapplication.mvvm.maindetail

import android.content.Context
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.util.Log
import com.apps.myapplication.R
import com.apps.myapplication.base.BaseActivity

class DetailActivity : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        replaceFragment(R.id.frame_main_content, DetailFragment(), "","")
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
    }

    override fun onBackPressed() {
        finish()
    }

}