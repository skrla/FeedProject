package skrla.feedprocject.model.data.api

import retrofit2.Call
import retrofit2.http.GET
import skrla.feedprocject.model.data.models.FeedApiData

interface FeedApi {

    @GET("feed?page=1&sport=football")
    fun getFeed() : Call<List<FeedApiData>>

}