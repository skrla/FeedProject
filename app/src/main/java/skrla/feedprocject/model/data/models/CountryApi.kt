package skrla.feedprocject.model.data.models

import com.google.gson.annotations.SerializedName

data class CountryApi(
    val id: Int,
    val name: String,
    val slug: String,
    @SerializedName("icon") val flagPic: String
)
