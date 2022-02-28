package skrla.feedprocject.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import skrla.feedprocject.model.data.api.RetrofitClient
import skrla.feedprocject.model.data.models.SportGroupApi

class SportGroupRepositoryImp(val application: Application) : SportGroupRepository {

    val sportGroupRepo = MutableLiveData<List<SportGroupApi>>()

    override fun getSportGroup(id: String): LiveData<List<SportGroupApi>> {

        RetrofitClient.retrofitFeed.getSportGroup(id).enqueue(object : Callback<List<SportGroupApi>> {

            override fun onResponse(
                call: Call<List<SportGroupApi>>,
                response: Response<List<SportGroupApi>>
            ) {
                if(response.isSuccessful) {
                    sportGroupRepo.value = response.body()!!
                } else {
                    Toast.makeText(application, "Error loading feed!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<SportGroupApi>>, t: Throwable) {
                Toast.makeText(application, "Error", Toast.LENGTH_SHORT).show()
            }
        })

        return sportGroupRepo
    }
}

interface SportGroupRepository {
    fun getSportGroup(id: String) : LiveData<List<SportGroupApi>>
}