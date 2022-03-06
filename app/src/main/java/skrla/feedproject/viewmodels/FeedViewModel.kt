package skrla.feedproject.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import skrla.feedproject.model.data.models.AthleteApi
import skrla.feedproject.model.data.models.FeedApiData
import skrla.feedproject.repository.AthleteRepositoryImp
import skrla.feedproject.repository.FeedRepositoryImp

class FeedViewModel(application: Application) : AndroidViewModel(application) {

    private val repositoryFeed = FeedRepositoryImp(application)
    private val repositoryAthlete = AthleteRepositoryImp(application)

    val feedApiData: LiveData<List<FeedApiData>>
    val athleteApi: LiveData<List<AthleteApi>>

    init {
        feedApiData = repositoryFeed.feedRepo
        athleteApi = repositoryAthlete.athleteRepo
    }

    fun getData() {
        viewModelScope.launch {
            repositoryFeed.getFeed()
            repositoryAthlete.getAthlete()
            @Suppress("BlockingMethodInNonBlockingContext")
            Thread.sleep(2000)
        }
    }

}