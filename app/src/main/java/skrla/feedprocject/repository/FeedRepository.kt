package skrla.feedprocject.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import skrla.feedprocject.model.data.api.RetrofitClient.Companion.retrofitFeed
import skrla.feedprocject.model.data.models.FeedApiData

class FeedRepositoryImp(val application: Application) : FeedRepository {

    val feedRepo = MutableLiveData<List<FeedApiData>>()

    override fun getFeed(): LiveData<List<FeedApiData>> {
        retrofitFeed.getFeed().enqueue(object : Callback<List<FeedApiData>> {

            override fun onResponse(
                call: Call<List<FeedApiData>>,
                response: Response<List<FeedApiData>>
            ) {
                if(response.isSuccessful) {
                    feedRepo.value = response.body()!!
                } else {
                    Toast.makeText(application, "Error loading feed!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<FeedApiData>>, t: Throwable) {
                Toast.makeText(application, "Error", Toast.LENGTH_SHORT).show()
            }
        })

        return feedRepo
    }
}

interface FeedRepository {
    fun getFeed(): LiveData<List<FeedApiData>>
}