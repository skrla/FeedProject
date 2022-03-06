package skrla.feedproject.model.data.models

import com.google.gson.annotations.SerializedName

data class CountryApi(
    val id: String,
    val name: String,
    val slug: String,
    @SerializedName("icon") val flagPic: String
)
