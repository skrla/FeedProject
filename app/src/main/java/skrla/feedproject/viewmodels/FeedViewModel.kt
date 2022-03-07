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
import skrla.feedproject.repository.SingleAthleteRepositoryImp

class FeedViewModel(application: Application) : AndroidViewModel(application) {

    private val repositoryFeed = FeedRepositoryImp(application)
    private val repositoryAthlete = AthleteRepositoryImp(application)
    private val repositorySingleAthlete = SingleAthleteRepositoryImp(application)

    val feedApiData: LiveData<List<FeedApiData>>
    val athleteApi: LiveData<List<AthleteApi>>
    val singleAthleteApi: LiveData<AthleteApi>
    var videoUrl: String? = null

    init {
        feedApiData = repositoryFeed.feedRepo
        athleteApi = repositoryAthlete.athleteRepo
        singleAthleteApi = repositorySingleAthlete.singleAthleteRepo
    }

    fun getData() {
        viewModelScope.launch {
            repositoryFeed.getFeed()
            repositoryAthlete.getAthlete()
        }
    }

    fun getAthleteData(id: String) {
        viewModelScope.launch {
            repositorySingleAthlete.getSingleAthlete(id)
            Thread.sleep(700)
        }
    }

    fun getVideoUrl(url: String) {
        videoUrl = url
    }

}