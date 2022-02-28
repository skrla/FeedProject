package skrla.feedprocject.model.data.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import skrla.feedprocject.model.data.models.*

interface FeedApi {

    @GET("feed?page=1&sport=football")
    fun getFeed() : Call<List<FeedApiData>>

    @GET("athlete")
    fun getAthlete() : Call<List<AthleteApi>>

    @GET("country")
    fun getCountry() : Call<List<CountryApi>>

    @GET("sport")
    fun getSport() : Call<List<SportApi>>

    @GET("sport/{id}/group")
    fun getSportGroup(@Path("id") id: String): Call<List<SportGroupApi>>

}