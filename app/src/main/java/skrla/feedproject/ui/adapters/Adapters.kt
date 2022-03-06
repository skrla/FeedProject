package skrla.feedproject.ui.adapters

import android.net.Uri
import android.widget.ImageView
import android.widget.VideoView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import skrla.feedproject.R
import skrla.feedproject.model.data.models.AthleteApi
import skrla.feedproject.model.data.models.FeedApiData

@BindingAdapter("imageUrl")
fun bindProfilePic(imgView: ImageView, profilePic: String?) {
    if (profilePic?.contains("https://drive.google.com") == true) {
        var profilePicId = profilePic.removePrefix("https://drive.google.com/open?id=").removeSuffix("/view")
        profilePicId = "drive.google.com/uc?export=view&id=$profilePicId"
        val profilePicUri = profilePicId.toUri().buildUpon().scheme("https").build()
        imgView.load(profilePicUri) {
            placeholder(R.drawable.ic_launcher_background)
            placeholder(R.drawable.ic_launcher_foreground)
        }
    } else {
        val profilePicUri= profilePic!!.toUri().buildUpon().scheme("https:").build()
        imgView.load(profilePicUri) {
            placeholder(R.drawable.ic_launcher_background)
            placeholder(R.drawable.ic_launcher_foreground)
        }
    }
}



@BindingAdapter("feedList")
fun bindFeedRecycler(recyclerView: RecyclerView, data: List<FeedApiData>?) {
    val adapter = recyclerView.adapter as FeedAdapter
    adapter.submitList(data)
}

@BindingAdapter("athleteList")
fun bindAthleteRecycler(recyclerView: RecyclerView, data: List<AthleteApi>?) {
    val adapter = recyclerView.adapter as AthleteAdapter
    adapter.submitList(data)
}

@BindingAdapter("videoUrl")
fun bindVideoUrl(videoView: VideoView, videoUrl: String?) {
    videoView.setVideoURI(Uri.parse(videoUrl))
}
