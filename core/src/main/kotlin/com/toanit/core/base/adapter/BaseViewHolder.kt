package com.toanit.core.base.adapter

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by Toan.IT on 6/19/17.
 * Email: huynhvantoan.itc@gmail.com
 */

abstract class BaseViewHolder<in T>(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBind(item: T)

}