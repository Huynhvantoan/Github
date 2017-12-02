package com.toanit.core.base.adapter

import android.annotation.SuppressLint
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BindableViewHolder<M>(parent : ViewGroup, @LayoutRes layout : Int) : RecyclerView.ViewHolder(parent.inflate(layout)) {
    abstract fun bind(model : M)
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}