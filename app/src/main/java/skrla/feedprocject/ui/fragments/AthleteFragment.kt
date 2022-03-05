package skrla.feedprocject.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import skrla.feedprocject.databinding.FragmentAthleteBinding
import skrla.feedprocject.ui.adapters.AthleteAdapter
import skrla.feedprocject.viewmodels.FeedViewModel


class AthleteFragment : Fragment() {

    private val feedViewModel: FeedViewModel by activityViewModels()

    private var _binding: FragmentAthleteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAthleteBinding.inflate(inflater)
        binding.let {
            it.lifecycleOwner = this
            it.feedViewModel = feedViewModel
            it.athleteRecycler.adapter = AthleteAdapter()
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}