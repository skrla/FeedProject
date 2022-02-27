package skrla.feedprocject.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import skrla.feedprocject.databinding.FragmentFeedBinding
import skrla.feedprocject.ui.adapters.FeedAdapter
import skrla.feedprocject.viewmodels.FeedViewModel


class FeedFragment : Fragment() {

    private val feedViewModel: FeedViewModel by activityViewModels()

    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFeedBinding.inflate(inflater)
        binding.let {
            it.lifecycleOwner = this
            it.feedFragment = feedViewModel
            it.feedRecyclerView.adapter = FeedAdapter()
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}