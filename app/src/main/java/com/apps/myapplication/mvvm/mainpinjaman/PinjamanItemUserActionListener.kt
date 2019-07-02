package com.apps.myapplication.mvvm.mainpinjaman

import com.apps.myapplication.data.model.Loan


interface PinjamanItemUserActionListener {
    fun onNewsClicked(news: Loan)
}