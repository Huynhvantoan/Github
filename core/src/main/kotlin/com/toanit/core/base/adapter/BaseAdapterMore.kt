package com.toanit.core.base.adapter

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.util.SparseIntArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.toanit.core.base.adapter.BaseAdapterMore.BaseViewHolder
import com.toanit.core.R
import kotlinx.android.synthetic.main.list_item_load_more.view.*
/**
 * Created by Toan.IT on 6/19/17.
 * Email: huynhvantoan.itc@gmail.com
 */

abstract class BaseAdapterMore<T>(
        val mDatas: MutableList<T> = mutableListOf(),
        @LayoutRes defaultLayoutId: Int) : RecyclerView.Adapter<BaseViewHolder>() {

    companion object {
        private val LOAD_MORE_THRESHOLD = 5
        private val VIEW_TYPE_LOAD_MORE = -0xff
        private val VIEW_TYPE_DEFAULT = -0xfe
    }

    private val mLayouts =SparseIntArray()
    private var mLoadMoreComplete: Boolean = false
    private var mLoadMoreFailed: Boolean = false
    lateinit var mOnLoadMoreListener: (BaseAdapterMore<T>) -> Unit

    init {
        mLayouts.put(VIEW_TYPE_LOAD_MORE, R.layout.list_item_load_more)
        mLayouts.put(VIEW_TYPE_DEFAULT, defaultLayoutId)
    }

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
        notifyLoadMoreEvent(position)
        when (getItemViewType(position)) {
            VIEW_TYPE_DEFAULT -> bindDefault(holder, mDatas[position])
            VIEW_TYPE_LOAD_MORE -> showLoadMore(holder)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == itemCount - 1) {
            return VIEW_TYPE_LOAD_MORE
        }
        return VIEW_TYPE_DEFAULT
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder {
        return BaseViewHolder(
                LayoutInflater.from(parent!!.context).inflate(mLayouts.get(viewType), parent,
                        false))
    }

    override fun getItemCount(): Int = mDatas.size + 1

    abstract fun bindDefault(holder: BaseViewHolder?, itemData: T)

    private fun notifyLoadMoreEvent(position: Int) {
        if (position == mDatas.size - LOAD_MORE_THRESHOLD && mOnLoadMoreListener != null) {
            mLoadMoreComplete = false
            mLoadMoreFailed = false
            mOnLoadMoreListener(this)
        }
    }

    private fun showLoadMore(holder: BaseViewHolder?) {
        holder?.itemView?.load_more_progressbar?.visibility = if (shouldShowLoadMore())
            View.VISIBLE else View.GONE
    }

    private fun shouldShowLoadMore(): Boolean = !mLoadMoreComplete && !mLoadMoreFailed

    fun loadMoreFailed() {
        mLoadMoreFailed = true
        notifyItemChanged(mDatas.size)
    }

    fun loadMoreComplete() {
        mLoadMoreComplete = true
        notifyItemChanged(mDatas.size)
    }

    fun addDatas(list: List<T>) {
        val preSize = mDatas.size
        mDatas.addAll(list)
        notifyItemRangeChanged(preSize, mDatas.size)
    }

    class BaseViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)

    //Use
    /*class MoviesAdapter(val activity: MoviesActivity,
                        layoutResId: Int = R.layout.list_item_movie_1) :
            BaseAdapter<Video>(defaultLayoutId = layoutResId) {

        override fun bindDefault(holder: BaseViewHolder?, itemData: Video) {
            holder?.itemView?.poster?.load(activity, itemData.realBackdropPath)
            holder?.itemView?.title?.text = itemData.title
        }
    }*/
}