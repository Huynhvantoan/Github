package com.toanit.core.libs

import android.support.v7.util.DiffUtil

/**
 * Created by Toan.IT on 6/29/17.
 * Email: huynhvantoan.itc@gmail.com
 */

class BaseDiffCallback<T>(private val oldList: List<T>, private val newList: List<T>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]

        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    /*use*/
   /* fun swapItems(list: List<GenericItem>) {
        val diffCallback = BaseDiffCallback(this.items, list)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.items.clear()
        this.items.addAll(list)
        diffResult.dispatchUpdatesTo(this)
    }
*/
}
