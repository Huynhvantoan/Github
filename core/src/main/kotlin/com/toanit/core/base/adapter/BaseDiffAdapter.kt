package hu.nemi.feed.ui

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.toanit.core.base.adapter.BindableViewHolder

class BaseAdapter<M>(private val viewHolderFactory: (ViewGroup, Int) -> BindableViewHolder<M>, private val viewTypeMapper: (M) -> Int = { 1 }) : RecyclerView.Adapter<BindableViewHolder<M>>() {
    var data: List<M> = emptyList()

    override fun onBindViewHolder(viewHolder: BindableViewHolder<M>, position: Int) {
        viewHolder.bind(data[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = viewHolderFactory.invoke(parent, viewType)

    override fun getItemViewType(position: Int) = viewTypeMapper.invoke(data[position])

    override fun getItemCount(): Int = data.size

    operator fun get(position: Int) = data[position]
}

/*

data class AdapterUpdate<M>(val data: List<M>, private val diff: DiffUtil.DiffResult?) {
    companion object {
        fun <M> empty() = AdapterUpdate<M>(emptyList(), null)
    }

    fun apply(adapter: BaseAdapter<M>) {
        adapter.data = data
        diff?.dispatchUpdatesTo(adapter) ?: adapter.notifyDataSetChanged()
    }
}

class FeedLiveData(private val repository: FeedRepository) : LiveData<AdapterUpdate<FeedItem>>() {
    private var streamDisposable: Disposable? = null

    override fun onActive() {
        onInactive()

        streamDisposable = repository.feed()
                .scan(AdapterUpdate.empty<FeedItem>()) { old, new ->
                    AdapterUpdate(new, DiffUtil.calculateDiff(diff(old.data, new), true))
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { value = it }
    }

    override fun onInactive() {
        streamDisposable?.dispose()
    }

    private fun diff(oldData: List<FeedItem>, newData: List<FeedItem>) = object : DiffUtil.Callback() {
        override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean = oldData[oldPosition].url == newData[newPosition].url

        override fun getOldListSize(): Int = oldData.size

        override fun getNewListSize(): Int = newData.size

        override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean = oldData[oldPosition] == newData[newPosition]
    }
}

*/
