package com.apps.myapplication.mvvm.mainpinjaman

import android.arch.lifecycle.MutableLiveData
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.apps.myapplication.data.model.Loan

object PinjamanBinding {
    @BindingAdapter("app:pinjamanList")
    @JvmStatic
    fun setNewsList(recyclerView: RecyclerView, movies: MutableLiveData<List<Loan>>?) {
        try {
            with(recyclerView.adapter as PinjamanAdapter) {
                if (movies?.value?.isNotEmpty()!!) {
                    Log.d("cekdatapinjaman",""+ movies.value!![0].title)
                    replaceData(movies?.value!!)
                }
            }
        } catch (e: Exception){
            e.printStackTrace()
        }
    }

}