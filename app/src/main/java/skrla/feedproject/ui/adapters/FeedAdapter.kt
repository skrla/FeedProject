package skrla.feedproject.ui.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import skrla.feedproject.databinding.FeedDataBinding
import skrla.feedproject.model.data.models.FeedApiData

class FeedAdapter : ListAdapter<FeedApiData, FeedAdapter.FeedViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<FeedApiData>() {
        override fun areItemsTheSame(oldItem: FeedApiData, newItem: FeedApiData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FeedApiData, newItem: FeedApiData): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return FeedViewHolder(
            FeedDataBinding.inflate(LayoutInflater.from(parent.context))

        )
    }

    override fun onViewAttachedToWindow(holder: FeedViewHolder) {
        holder.isOnWindow()
        super.onViewAttachedToWindow(holder)
    }

    override fun onViewDetachedFromWindow(holder: FeedViewHolder) {
        holder.isNotOnWindow()
        super.onViewDetachedFromWindow(holder)
    }

    override fun onViewRecycled(holder: FeedViewHolder) {
        holder.isRecycled()
        super.onViewRecycled(holder)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val feedId = getItem(position)
        holder.bind(feedId)

    }

    override fun onCurrentListChanged(
        previousList: MutableList<FeedApiData>,
        currentList: MutableList<FeedApiData>
    ) {
        super.onCurrentListChanged(previousList, currentList)
    }
    class FeedViewHolder(private var binding: FeedDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(feed: FeedApiData) {
            binding.feed = feed
            binding.executePendingBindings()
        }
        fun isOnWindow() {
            if (binding.videoView.currentPosition == 0 ) {
                binding.videoView.start()
            } else {
                binding.videoView.resume()
            }
        }
        fun isNotOnWindow() {
            binding.videoView.pause()
        }
        fun isRecycled() {
            binding.videoView.stopPlayback()
        }

    }
}