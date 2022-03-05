package skrla.feedprocject.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import skrla.feedprocject.databinding.FragmentSingleAthleteBinding
import skrla.feedprocject.viewmodels.FeedViewModel

class SingleAthleteFragment : Fragment() {

    private val feedViewModel: FeedViewModel by activityViewModels()

    private var _binding: FragmentSingleAthleteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSingleAthleteBinding.inflate(inflater)
        binding.let {
            it.lifecycleOwner = this
        }


        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}