package com.apps.myapplication.mvvm.mainhome

import com.apps.myapplication.data.model.Book


interface HomeItemUserActionListener {
    fun onBookClicked(book: Book)
}