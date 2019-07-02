package com.apps.myapplication.mvvm.mainpinjaman

import android.app.Activity
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.apps.myapplication.data.model.Loan
import com.apps.myapplication.data.source.local.RealmHelper


class PinjamanViewModel(context: Application, activity: Activity) : AndroidViewModel(context)  {

    var newList = MutableLiveData<List<Loan>>()
    val booklist = ArrayList<Loan>()
    var showProgress = MutableLiveData<Boolean>()
    var mcontext = context;
    var mactivity = activity;

    fun start() {
        getNews()
    }

    fun clearList(){
        booklist.clear()
        newList.postValue(booklist);
    }
    fun getNews() {
        showProgress.value = true
        var book = RealmHelper.getrealm(mcontext).where(com.apps.myapplication.data.source.local.model.Book::class.java)
            .findAll()
        var cat = RealmHelper.getrealm(mcontext).where(com.apps.myapplication.data.source.local.model.Category::class.java).findAll()
        booklist.clear()
        for(i in 0..book.size-1){
            var index = i
            var cekpinajaman = RealmHelper.getrealm(mcontext)
                .where(com.apps.myapplication.data.source.local.model.Loan::class.java).equalTo("idbook",index)
                .findAll()
            if(cekpinajaman.size > 0){
                Log.d("cektanggal",""+cekpinajaman[0]?.date_borrow!!)
                var b = Loan(cekpinajaman[0]?.date_borrow!!,cekpinajaman[0]?.date_return!!,""+index,
                    book[i]?.author!!,book[i]?.title!!,book[i]?.img!!,
                    cat[book[i]?.idcategory!!]?.name.toString(),book[i]?.qty!!)
                booklist.add(b)
            }
        }
        newList.postValue(booklist);
        showProgress.value = false

    }



}