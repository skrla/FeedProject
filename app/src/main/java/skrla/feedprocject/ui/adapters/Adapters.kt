package skrla.feedprocject.ui.adapters

import android.net.Uri
import android.widget.ImageView
import android.widget.VideoView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import skrla.feedprocject.model.data.models.FeedApiData

@BindingAdapter("imageUrl")
fun bindProfilePic(imgView: ImageView, profilePic: String?) {
    profilePic?.let {
        val profilePicUri = profilePic.toUri().buildUpon().scheme("https").build()
        imgView.load(profilePicUri)
    }
}

@BindingAdapter("feedList")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<FeedApiData>?) {
    val adapter = recyclerView.adapter as FeedAdapter
    adapter.submitList(data)
}

@BindingAdapter("videoUrl")
fun bindVideoUrl(videoView: VideoView, videoUrl: String?) {
    val video = videoView
    video.setVideoURI(Uri.parse(videoUrl))
    if (video.isFocused) {
        video.start()
    } else {
      video.pause()
    }
}