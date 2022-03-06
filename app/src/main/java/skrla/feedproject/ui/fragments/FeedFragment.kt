package skrla.feedproject.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import skrla.feedproject.databinding.FragmentFeedBinding
import skrla.feedproject.ui.adapters.FeedAdapter
import skrla.feedproject.viewmodels.FeedViewModel


class FeedFragment : Fragment() {

    private val feedViewModel: FeedViewModel by activityViewModels()

    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeedBinding.inflate(inflater)
        binding.let {
            it.lifecycleOwner = this
            it.feedViewModel = feedViewModel
            it.feedRecyclerView.adapter = FeedAdapter()
        }
        binding.swipeRefreshLayout.setOnRefreshListener {
            if (binding.swipeRefreshLayout.isRefreshing) {
                feedViewModel.getData()
                binding.swipeRefreshLayout.isRefreshing = false
            }
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}