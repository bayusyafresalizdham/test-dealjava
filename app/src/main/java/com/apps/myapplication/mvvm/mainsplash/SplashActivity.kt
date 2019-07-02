package com.apps.myapplication.mvvm.mainsplash

import android.os.Bundle
import com.apps.myapplication.R
import com.apps.myapplication.base.BaseActivity
import android.content.Intent
import android.os.Handler
import android.util.Log
import com.apps.myapplication.mvvm.main.MainActivity
import com.github.nkzawa.socketio.client.Socket

class SplashActivity : BaseActivity(){
    var timemillis : Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        initBook()
        Log.d("cekbuku",""+book.size)
        if(book.size > 0){
            timemillis = 2000
        }else{
            timemillis = 5000
        }
        initValueCategory()
        initValueBook()
        Handler().postDelayed(Runnable {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, timemillis)

    }




}