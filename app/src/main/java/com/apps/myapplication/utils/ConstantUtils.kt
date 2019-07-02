package com.apps.myapplication.utils

import android.arch.lifecycle.MutableLiveData
import java.util.*


class ConstantUtils {
    companion object {
        fun BASE_URL() : String = "https://newsapi.org/"
        fun API_KEY() : String = "e001b31f8aab4f87bab8670602fa6b8f"
        var check_timer : Boolean = false
        var author = ""
        var title = ""
        var img = ""
        var idcategory =""
        var qty = 0
        var index = 0

        fun addDays(date: Date, days: Int): Date {
            val cal = Calendar.getInstance()
            cal.setTime(date)
            cal.add(Calendar.DATE, days) //minus number would decrement the days
            return cal.getTime()
        }
    }
}