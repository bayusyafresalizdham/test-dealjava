package com.apps.myapplication.mvvm.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.apps.myapplication.mvvm.mainhome.HomeFragment
import com.apps.myapplication.mvvm.mainpinjaman.PinjamanFragment

class TabAdapter(fm: FragmentManager): FragmentPagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                HomeFragment.newInstance("home")
            }
            1 -> {
                HomeFragment.newInstance("0")
            }
            2 -> {
                HomeFragment.newInstance("1")
            }
            3 -> {
                HomeFragment.newInstance("2")
            }
            else -> {
                return PinjamanFragment.newInstance("home")
            }
        }
    }

    override fun getCount(): Int {
        return 5
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Home"
            1 -> "Novel"
            2 -> "Biografi"
            3 -> "Bisnis"
            else -> {
                return "Pinjaman"
            }
        }
    }
}