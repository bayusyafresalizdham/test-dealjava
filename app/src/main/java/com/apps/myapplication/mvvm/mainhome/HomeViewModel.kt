package com.apps.myapplication.mvvm.mainhome

import android.app.Activity
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.content.Intent
import android.os.CountDownTimer
import android.support.annotation.StringRes
import android.util.Log
import android.widget.Toast
import com.apps.myapplication.utils.ConstantUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.databinding.adapters.TextViewBindingAdapter.setText
import com.apps.myapplication.data.model.Book
import com.apps.myapplication.data.source.local.RealmHelper
import com.apps.myapplication.data.source.local.model.Category
import com.apps.myapplication.mvvm.maindetail.DetailActivity


class HomeViewModel(context: Application, activity: Activity) : AndroidViewModel(context)  {

    var newList = MutableLiveData<List<Book>>()
    val booklist = ArrayList<Book>()
    var showProgress = MutableLiveData<Boolean>()
    var mcontext = context;
    var mactivity = activity;

    companion object {
        fun openDetailNews() : Book? = null
    }

    fun start(kategori : String) {
        getBook(kategori)
        start_slide()
    }

    fun start_slide(){

    }
    fun getBook(kategori : String) {
        showProgress.value = true
        var book = RealmHelper.getrealm(mcontext).where(com.apps.myapplication.data.source.local.model.Book::class.java)
            .findAll()
        if(!kategori.equals("home")){
            var k : Int = Integer.parseInt(kategori);
            book = RealmHelper.getrealm(mcontext).where(com.apps.myapplication.data.source.local.model.Book::class.java)
                .equalTo("idcategory",k).findAll()
        }
        var cat = RealmHelper.getrealm(mcontext).where(com.apps.myapplication.data.source.local.model.Category::class.java).findAll()
        booklist.clear()
        for(i in 0..book.size-1){
            var b = Book(book[i]?.author!!,book[i]?.title!!,book[i]?.img!!,
                cat[book[i]?.idcategory!!]?.name.toString()
                ,book[i]?.qty!!)
            booklist.add(b)
        }
        newList.postValue(booklist);
        showProgress.value = false

    }



}