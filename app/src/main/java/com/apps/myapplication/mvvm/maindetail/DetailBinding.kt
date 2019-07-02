package com.apps.myapplication.mvvm.maindetail

import android.databinding.BindingAdapter
import android.text.TextUtils
import android.util.Log
import android.widget.ImageView
import com.apps.myapplication.R
import com.squareup.picasso.Picasso

object DetailBinding {

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
