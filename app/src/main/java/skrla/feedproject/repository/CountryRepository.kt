package skrla.feedproject.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import skrla.feedproject.model.data.api.RetrofitClient
import skrla.feedproject.model.data.models.CountryApi

class CountryRepositoryImp(val application: Application) : CountryRepository {

    val countryRepo = MutableLiveData<List<CountryApi>>()

    override fun getCountry() : LiveData<List<CountryApi>> {
        RetrofitClient.retrofitFeed.getCountry().enqueue(object : Callback<List<CountryApi>> {
            override fun onResponse(
                call: Call<List<CountryApi>>,
                response: Response<List<CountryApi>>
            ) {
                if (response.isSuccessful) {
                    countryRepo.value = response.body()!!
                } else {
                    Toast.makeText(application, "Error loading feed!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<CountryApi>>, t: Throwable) {
                Toast.makeText(application, "Error", Toast.LENGTH_SHORT).show()
            }

        })

        return countryRepo
    }
}

interface CountryRepository {
    fun getCountry() : LiveData<List<CountryApi>>
}