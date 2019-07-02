package com.apps.myapplication.mvvm.mainpinjaman

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
import com.apps.myapplication.data.model.Loan
import com.apps.myapplication.data.source.local.RealmHelper
import com.apps.myapplication.databinding.PinjamanItemBinding
import com.apps.myapplication.mvvm.maindetail.DetailActivity
import com.apps.myapplication.utils.ConstantUtils

class PinjamanAdapter(private var news: List<Loan>, private var context: Activity, private var mainViewModel: PinjamanViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        val item = news[p1]


        val userActionListener = object : PinjamanItemUserActionListener {
            override fun onNewsClicked(news: Loan) {
                var h : Int = Integer.parseInt(news.idbook);
                var cekpinajaman = RealmHelper.getrealm(context.applicationContext)
                    .where(com.apps.myapplication.data.source.local.model.Loan::class.java).equalTo("idbook",h)
                    .findAll()
                RealmHelper.getrealm(context.applicationContext).beginTransaction()
                cekpinajaman[0]?.deleteFromRealm()
                RealmHelper.getrealm(context.applicationContext).commitTransaction()

                var book = RealmHelper.getrealm(context.applicationContext)
                    .where(com.apps.myapplication.data.source.local.model.Book::class.java)
                    .findAll()
                RealmHelper.getrealm(context.applicationContext).beginTransaction()
                book[h]?.qty = 1
                RealmHelper.getrealm(context.applicationContext).commitTransaction()
                mainViewModel.start()
                notifyDataSetChanged()
                Toast.makeText(context.applicationContext,"Terimakasih Telah Mengembalikan Buku",Toast.LENGTH_LONG).show()

            }
        }

        (p0 as MainItemHolder).bindItem(item, userActionListener)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val mainItemBinding: PinjamanItemBinding = DataBindingUtil.inflate(LayoutInflater.from(p0!!.context),
            R.layout.pinjaman_item, p0, false)

        return MainItemHolder(mainItemBinding)
    }

    override fun getItemCount(): Int = news.size

    fun replaceData(news: List<Loan>) {
        setList(news)
    }

    fun setList(news: List<Loan>) {
        this.news = news

        notifyDataSetChanged()
    }

    class MainItemHolder(itemView: PinjamanItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        private val mainItemBinding = itemView

        fun bindItem(news: Loan, userActionListener: PinjamanItemUserActionListener) {
            Log.d("cek",""+news.img);
            mainItemBinding.item = news
            mainItemBinding.userActionListener = userActionListener
            mainItemBinding.executePendingBindings()
        }
    }
}
