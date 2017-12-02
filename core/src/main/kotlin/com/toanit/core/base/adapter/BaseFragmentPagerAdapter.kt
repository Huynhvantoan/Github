package com.toanit.core.base.adapter

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

import java.util.Arrays

/**
 * Created by Toan.IT on 6/19/17.
 * Email: huynhvantoan.itc@gmail.com
 */

abstract class BaseFragmentPagerAdapter<T>(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var list: List<T>? = null
        private set(list) {
            field = list
            notifyDataSetChanged()
        }

    override fun getCount(): Int {
        return if (list != null) list!!.size else 0
    }
/*
    fun setList(list: Array<T>) {
        list = Arrays.asList(*list)
    }*/
}
