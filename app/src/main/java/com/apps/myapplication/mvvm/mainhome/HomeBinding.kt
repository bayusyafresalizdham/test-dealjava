package com.apps.myapplication.mvvm.mainhome

import android.arch.lifecycle.MutableLiveData
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.ImageView
import com.apps.myapplication.R
import com.apps.myapplication.data.model.Book
import com.squareup.picasso.Picasso

object HomeBinding {

    @BindingAdapter("app:newsList")
    @JvmStatic
    fun setNewsList(recyclerView: RecyclerView, movies: MutableLiveData<List<Book>>?) {
        try {
            with(recyclerView.adapter as HomeAdapter) {
                if (movies?.value?.isNotEmpty()!!) {
                    Log.d("cekdata",""+ movies.value!![0].title)
                    replaceData(movies?.value!!)
                }
            }
        } catch (e: Exception){
            e.printStackTrace()
        }
    }

    @BindingAdapter("app:imageSource")
    @JvmStatic
    fun setImageSource(imageView: ImageView, urlSource: String?) {
        Log.d("cekurl",""+urlSource)
        Picasso.get()
            .load(urlSource)
            .error(R.color.colorPrimary)
            .into(imageView)
    }

}