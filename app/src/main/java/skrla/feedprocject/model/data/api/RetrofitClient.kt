package skrla.feedprocject.model.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val FEED_URL = "https://private-anon-21a471b81a-technicaltaskapi.apiary-mock.com/"

class RetrofitClient {
    companion object {

        private val client = OkHttpClient.Builder()

        private val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(FEED_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()
        }

        val retrofitFeed: FeedApi by lazy { retrofit.create(FeedApi::class.java) }

    }
}