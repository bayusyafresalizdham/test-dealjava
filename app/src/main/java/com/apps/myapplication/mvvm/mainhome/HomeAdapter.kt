package com.apps.myapplication.mvvm.mainhome

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.apps.myapplication.R
import com.apps.myapplication.data.model.Book
import com.apps.myapplication.databinding.HomeItemBinding
import com.apps.myapplication.mvvm.maindetail.DetailActivity
import com.apps.myapplication.utils.ConstantUtils

class HomeAdapter(private var books: List<Book>,private var context: Activity, private var mainViewModel: HomeViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        val item = books[p1]

        val userActionListener = object : HomeItemUserActionListener {
            override fun onBookClicked(book: Book) {
                ConstantUtils.index = p1;
                ConstantUtils.title = book.title
                ConstantUtils.author = book.author
                ConstantUtils.img = book.img
                ConstantUtils.idcategory = book.idcategory
                ConstantUtils.qty = book.qty
                val i = Intent(context,DetailActivity::class.java)
                context.startActivity(i)
            }
        }

        (p0 as MainItemHolder).bindItem(item, userActionListener)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val mainItemBinding: HomeItemBinding = DataBindingUtil.inflate(LayoutInflater.from(p0!!.context),
            R.layout.home_item, p0, false)

        return MainItemHolder(mainItemBinding)
    }

    override fun getItemCount(): Int = books.size

    fun replaceData(books: List<Book>) {
        setList(books)
    }

    fun setList(books: List<Book>) {
        this.books = books

        notifyDataSetChanged()
    }

    class MainItemHolder(itemView: HomeItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        private val mainItemBinding = itemView

        fun bindItem(book: Book, userActionListener: HomeItemUserActionListener) {
            Log.d("cek",""+book.img);
            mainItemBinding.item = book
            mainItemBinding.userActionListener = userActionListener
            mainItemBinding.executePendingBindings()
        }
    }
}
