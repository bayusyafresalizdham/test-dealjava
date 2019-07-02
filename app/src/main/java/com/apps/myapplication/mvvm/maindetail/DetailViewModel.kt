package com.apps.myapplication.mvvm.maindetail


import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.support.annotation.StringRes
import android.util.Log
import android.widget.Toast
import com.apps.myapplication.utils.ConstantUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.support.design.widget.Snackbar
import android.support.v4.os.HandlerCompat.postDelayed
import android.R.attr.password
import android.app.Activity
import com.apps.myapplication.data.source.local.RealmHelper
import com.apps.myapplication.data.source.local.model.Book
import com.apps.myapplication.data.source.local.model.Loan
import java.text.SimpleDateFormat
import java.util.*


class DetailViewModel(context: Application,activity: Activity) : AndroidViewModel(context)  {

    var author = MutableLiveData<String>()
    var kategori = MutableLiveData<String>()
    var title= MutableLiveData<String>()
    var img= MutableLiveData<String>()
    var qty= MutableLiveData<Int>()
    var mcontext = context;
    var mactivity = activity;


    fun start() {
        getDetail()
    }

    fun getDetail() {
        author.postValue(ConstantUtils.author)
        title.postValue(ConstantUtils.title)
        kategori.postValue(ConstantUtils.idcategory)
        img.postValue(ConstantUtils.img)
        qty.postValue(ConstantUtils.qty)
    }

    fun onClickFinish() {
        mactivity.finish()
    }

    fun pinjamBuku() {
        var book = RealmHelper.getrealm(mcontext).where(com.apps.myapplication.data.source.local.model.Book::class.java).findAll()
        if(ConstantUtils.qty > 0){
            RealmHelper.getrealm(mcontext).beginTransaction()
            book[ConstantUtils.index]?.qty = 0
            RealmHelper.getrealm(mcontext).commitTransaction()

            RealmHelper.getrealm(mcontext).beginTransaction()
            val dNow = Date()
            val ft = SimpleDateFormat("E yyyy.MM.dd hh:mm:ss")
            var myDate = ft.parse(ft.format(dNow))
            myDate = ConstantUtils.addDays(myDate, 1)
            Log.d("cektanggal",ft.format(dNow)+" "+ft.format(myDate))
            val db = RealmHelper.getrealm(mcontext).createObject(Loan::class.java)
            db.idbook = ConstantUtils.index
            db.date_borrow = ft.format(dNow)
            db.date_return = ft.format(myDate)
            RealmHelper.getrealm(mcontext).commitTransaction()
            ConstantUtils.qty = 0
            qty.postValue(ConstantUtils.qty)
        }else{
            Toast.makeText(mcontext,"Stok buku tidak ada",Toast.LENGTH_LONG).show()
        }
    }

}