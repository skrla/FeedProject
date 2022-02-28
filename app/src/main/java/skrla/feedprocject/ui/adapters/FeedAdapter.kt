package skrla.feedprocject.ui.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import skrla.feedprocject.databinding.FeedDataBinding
import skrla.feedprocject.model.data.models.FeedApiData
import skrla.feedprocject.ui.adapters.FeedAdapter.ViewHolder

class FeedAdapter : ListAdapter<FeedApiData, ViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<FeedApiData>() {
        override fun areItemsTheSame(oldItem: FeedApiData, newItem: FeedApiData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FeedApiData, newItem: FeedApiData): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FeedDataBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val feedId = getItem(position)
        holder.bind(feedId)
    }


    class ViewHolder(private var binding: FeedDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(feed: FeedApiData) {
            binding.feed = feed
            binding.executePendingBindings()
        }
    }
}