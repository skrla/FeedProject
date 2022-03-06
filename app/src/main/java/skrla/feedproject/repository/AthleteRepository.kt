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

class AthleteRepositoryImp(val application: Application) : AthleteRepository {

    val athleteRepo = MutableLiveData<List<AthleteApi>>()

    override fun getAthlete(): LiveData<List<AthleteApi>> {
        RetrofitClient.retrofitFeed.getAthlete().enqueue(object : Callback<List<AthleteApi>> {

            override fun onResponse(
                call: Call<List<AthleteApi>>,
                response: Response<List<AthleteApi>>
            ) {
                if(response.isSuccessful) {
                    athleteRepo.value = response.body()!!
                } else {
                    Toast.makeText(application, "Error loading feed!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<AthleteApi>>, t: Throwable) {
                Toast.makeText(application, "Error", Toast.LENGTH_SHORT).show()
            }
        })

        return athleteRepo
    }
}

interface AthleteRepository {
    fun getAthlete(): LiveData<List<AthleteApi>>
}