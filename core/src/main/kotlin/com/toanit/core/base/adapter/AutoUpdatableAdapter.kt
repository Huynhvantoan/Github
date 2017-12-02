package com.toanit.core.base.adapter

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView

/**
 * Created by Toan.IT on 6/19/17.
 * Email: huynhvantoan.itc@gmail.com
 */

interface AutoUpdatableAdapter
fun <T> RecyclerView.Adapter<*>.autoNotify(old: List<T>, new: List<T>, compare: (T, T) -> Boolean) {
    val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return compare(old[oldItemPosition], new[newItemPosition])
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return old[oldItemPosition] == new[newItemPosition]
        }

        override fun getOldListSize() = old.size

        override fun getNewListSize() = new.size
    })

    diff.dispatchUpdatesTo(this)
}

/*class ContentAdapter() : RecyclerView.Adapter<ContentAdapter.ViewHolder>(), AutoUpdatableAdapter {

    var items: List<Content> by Delegates.observable(emptyList()) {
        prop, old, new ->
        autoNotify(old, new) { o, n -> o.id == n.id }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.view_item))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(content: Content) = with(itemView) {
            image.loadUrl(content.image)
            text.text = content.text
        }
    }
}




private fun fillAdapter() {
     val oldItems = adapter.items
     adapter.items = provider.generate()
     adapter.notifyChanges(oldItems, adapter.items)
 }



  var items: List<Content> by Delegates.observable(emptyList()) {
  prop, oldList, newList -> autoNotify(oldList, newList) { o, n -> o.id == n.id }
}

*/