package com.toanit.core.base.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Toan.IT on 6/19/17.
 * Email: huynhvantoan.itc@gmail.com
 */

abstract class BaseAdapter<D, VH : BaseViewHolder<D>> : RecyclerView.Adapter<VH>() {

    var dataSource: List<D> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = dataSource.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent?.context)
        val view = inflater.inflate(getLayoutId(), parent, false)
        return instantiateViewHolder(view)
    }

    abstract fun getLayoutId(): Int

    abstract fun instantiateViewHolder(view: View?): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(getItem(position))
    }

    fun getItem(position: Int) = dataSource[position]

}

/*

class ReposAdapter : BaseAdapter<Repo, ReposAdapter.ReposViewHolder>() {

    override fun getItemViewId(): Int = R.layout.view_item

    override fun instantiateViewHolder(view: View?): ReposViewHolder = ReposViewHolder(view)

    class ReposViewHolder(itemView: View?) : BaseViewHolder<Repo>(itemView) {

        val tvName : TextView by lazy { itemView?.findViewById(R.id.tvName) as TextView }
        val tvDescription : TextView by lazy { itemView?.findViewById(R.id.tvDescription) as TextView }

        override fun onBind(item: Repo) {
            tvName.text = item.name
            tvDescription.text = item.description
        }

    }

}*/
