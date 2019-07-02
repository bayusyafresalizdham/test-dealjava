package com.apps.myapplication.base


import android.content.Context
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.apps.myapplication.data.source.local.RealmHelper
import com.apps.myapplication.data.source.local.model.Book
import com.apps.myapplication.data.source.local.model.Category
import io.realm.RealmResults


/**
 * Created by irfanirawansukirman on 26/01/18.
 */

open class BaseActivity : AppCompatActivity() {

    lateinit var book: RealmResults<Book>
    lateinit var category: RealmResults<Category>
    lateinit var mActiviy: AppCompatActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mActiviy = this
    }
    //Todo attach base context calligraphy font in here

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase);
    }

    fun initBook(){
        book = RealmHelper.getrealm(mActiviy.applicationContext)
            .where(com.apps.myapplication.data.source.local.model.Book::class.java).findAll()
    }
    fun initCategory(){
        category = RealmHelper.getrealm(mActiviy.applicationContext)
            .where(com.apps.myapplication.data.source.local.model.Category::class.java).findAll()
    }
    fun initValueCategory(){
        initCategory()
        if(category.size <= 0){
            addValueCategory("Novel")
            addValueCategory("Biografi")
            addValueCategory("Bisnis")
        }
    }
    fun addValueCategory(name: String){

        RealmHelper.getrealm(applicationContext).beginTransaction()
        val db = RealmHelper.getrealm(applicationContext).createObject(Category::class.java)
        db.name = name
        RealmHelper.getrealm(applicationContext).commitTransaction()
    }
    fun initValueBook(){
        initBook()
        if(book.size <=0 ){
            addValueBook("Andrea Hirata",
                "https://upload.wikimedia.org/wikipedia/id/8/8e/Laskar_pelangi_sampul.jpg",
                "Laskar Pelangi", 1, 0)
            addValueBook("Andrea Hirata",
                "https://upload.wikimedia.org/wikipedia/id/thumb/8/89/Sang_Pemimpi_sampul.jpg/220px-Sang_Pemimpi_sampul.jpg",
                "Sang Pemimpi", 1, 0)
            addValueBook("Dee Lestari",
                "https://upload.wikimedia.org/wikipedia/id/thumb/7/7f/Perahu_Kertas_Sampul.jpg/220px-Perahu_Kertas_Sampul.jpg",
                "Perahu Kertas", 1, 0)
            addValueBook("Eric Ries",
                "https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9780/6709/9780670921607.jpg",
                "Lean Startup", 1, 2)
            addValueBook("Simon Sinek",
                "https://scoopadm.apps-foundry.com/ebook-covers/47957/image_highres/ID_FYW2019MTH06FYW.jpg",
                "Find Your Why", 1, 2)
            addValueBook("Heria Windasuri",
                "https://scoopadm.apps-foundry.com/ebook-covers/47955/image_highres/ID_CP2019MTH06CP.jpg",
                "Coaching Practices", 1, 2)
            addValueBook("Tim Redaksi",
                "https://scoopadm.apps-foundry.com/ebook-covers/20867/big_covers/ID_MRKMI2015MTH01BSBIGM_B.jpg",
                "BOB SADINO Biografi Inspiratif", 1, 1)
            addValueBook("Tim Redaksi",
                "https://scoopadm.apps-foundry.com/ebook-covers/47713/image_highres/ID_TTB2019MTH05TTB.jpg",
                "Tan Tjeng Bok: Seniman Tiga Zaman", 1, 1)
            addValueBook("Alberthiene Endah",
                "https://scoopadm.apps-foundry.com/ebook-covers/5559/big_covers/ID_GPU2013MTH06KKAS_B.jpg",
                "Ken & Kaskus", 1, 1)
        }
    }
    fun addValueBook(author : String, img: String, title: String, qty: Int,idcategory:Int){
        RealmHelper.getrealm(applicationContext).beginTransaction()
        val db = RealmHelper.getrealm(applicationContext).createObject(Book::class.java)
        db.author = author
        db.img = img
        db.title = title
        db.qty = qty
        db.idcategory = idcategory
        RealmHelper.getrealm(applicationContext).commitTransaction()
    }
    fun addFragment(@IdRes containerViewId: Int,
                              fragment: Fragment,
                              fragmentTag: String) {
        supportFragmentManager
            .beginTransaction()
            .add(containerViewId, fragment, fragmentTag)
            .disallowAddToBackStack()
            .commit()
    }

    fun replaceFragment(@IdRes containerViewId: Int,
                                  fragment: Fragment,
                                  fragmentTag: String,
                                  @Nullable backStackStateName: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(containerViewId, fragment, fragmentTag)
            .addToBackStack(backStackStateName)
            .commit()
    }
}