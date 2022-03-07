package skrla.feedproject.ui.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import skrla.feedproject.databinding.FragmentVideoBinding
import skrla.feedproject.viewmodels.FeedViewModel

class VideoFragment : Fragment() {


    private val feedViewModel: FeedViewModel by activityViewModels()

    private var _binding: FragmentVideoBinding? = null
    private val binding get() = _binding!!

    lateinit var video: VideoView
    var mediaController: MediaController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoBinding.inflate(inflater, container, false)
        activity?.actionBar?.hide()
        binding.lifecycleOwner = this
        video = binding.singleVideo
        if (mediaController == null) {
            mediaController = MediaController(context)
            mediaController!!.setAnchorView(this.video)
        }
        video.setMediaController(mediaController)
        video.setVideoURI(Uri.parse(feedViewModel.videoUrl))
        video.requestFocus()
        video.start()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        video.resume()
    }

    override fun onPause() {
        super.onPause()
        video.pause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        video.resume()
    }

}