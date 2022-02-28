package skrla.feedprocject.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import skrla.feedprocject.databinding.FragmentFeedBinding
import skrla.feedprocject.model.data.models.FeedApiData
import skrla.feedprocject.repository.FeedRepositoryImp

class FeedViewModel(application: Application) : AndroidViewModel(application) {

    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!

    private val repositoryFeed = FeedRepositoryImp(application)

    val feedApiData: LiveData<List<FeedApiData>>

    init {
        Log.wtf("D:", "wtf")
        feedApiData = repositoryFeed.feedRepo
    }

    fun getFeed() {
        viewModelScope.launch {
            Thread.sleep(2000)
            repositoryFeed.getFeed()
        }
    }
}