package skrla.feedprocject.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import skrla.feedprocject.model.data.api.RetrofitClient
import skrla.feedprocject.model.data.models.SportApi

class SportRepositoryImp(val application: Application) : SportRepository {

    val sportRepo = MutableLiveData<List<SportApi>>()

    override fun getSport(): LiveData<List<SportApi>> {

        RetrofitClient.retrofitFeed.getSport().enqueue(object : Callback<List<SportApi>> {

            override fun onResponse(
                call: Call<List<SportApi>>,
                response: Response<List<SportApi>>
            ) {
                if(response.isSuccessful) {
                    sportRepo.value = response.body()!!
                } else {
                    Toast.makeText(application, "Error loading feed!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<SportApi>>, t: Throwable) {
                Toast.makeText(application, "Error", Toast.LENGTH_SHORT).show()
            }
        })

        return sportRepo
    }
}

interface SportRepository {
    fun getSport(): LiveData<List<SportApi>>
}