package skrla.feedproject.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import skrla.feedproject.R
import skrla.feedproject.databinding.FragmentSplashBinding
import skrla.feedproject.viewmodels.FeedViewModel


class SplashFragment : Fragment() {

    private val feedViewModel: FeedViewModel by activityViewModels()

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)

        feedViewModel.getData()

        Handler(Looper.getMainLooper()).postDelayed( {
            findNavController().navigate(R.id.action_splashFragment_to_feedFragment)
        }, 3000)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}