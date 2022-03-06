package skrla.feedproject.ui.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import skrla.feedproject.databinding.AthleteDataBinding
import skrla.feedproject.model.data.models.AthleteApi

class AthleteAdapter : ListAdapter<AthleteApi, AthleteAdapter.AthleteViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<AthleteApi>() {
        override fun areItemsTheSame(oldItem: AthleteApi, newItem: AthleteApi): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: AthleteApi, newItem: AthleteApi): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }

    }


    class AthleteViewHolder(private var binding: AthleteDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(athlete: AthleteApi) {
            binding.athlete = athlete
            binding.executePendingBindings()
        }

        fun expand() {
            if (binding.expandableLayout.isVisible) {
                binding.expandableLayout.visibility = View.GONE
            } else {
                binding.expandableLayout.visibility = View.VISIBLE
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AthleteViewHolder {
        return AthleteViewHolder(
        AthleteDataBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: AthleteViewHolder, position: Int) {
        val athleteId = getItem(position)
        holder.bind(athleteId)

        holder.itemView.setOnClickListener {
            holder.expand()
        }
    }
}

