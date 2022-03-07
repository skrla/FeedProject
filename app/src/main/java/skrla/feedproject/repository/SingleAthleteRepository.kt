package skrla.feedproject.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import skrla.feedproject.model.data.api.RetrofitClient
import skrla.feedproject.model.data.models.AthleteApi

class SingleAthleteRepositoryImp(val application: Application) : SingleAthleteRepository {

    val singleAthleteRepo = MutableLiveData<AthleteApi>()

    override fun getSingleAthlete(id: String) : LiveData<AthleteApi> {
        RetrofitClient.retrofitFeed.getSingleAthlete(id).enqueue(object : Callback<AthleteApi> {
            override fun onResponse(
                call: Call<AthleteApi>,
                response: Response<AthleteApi>
            ) {
                if (response.isSuccessful) {
                    singleAthleteRepo.value = response.body()!!
                } else {
                    Toast.makeText(application, "Error loading feed!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<AthleteApi>, t: Throwable) {
                Toast.makeText(application, "Error", Toast.LENGTH_SHORT).show()
            }

        })

        return singleAthleteRepo
    }
}

interface SingleAthleteRepository {
    fun getSingleAthlete(id: String) : LiveData<AthleteApi>
}