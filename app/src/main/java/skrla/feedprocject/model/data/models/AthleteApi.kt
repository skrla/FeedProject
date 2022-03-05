package skrla.feedprocject.model.data.models

import com.google.gson.annotations.SerializedName


data class AthleteApi(
    val id: String,
    val age: String,
    val name: String,
    @SerializedName("avatar") val picOfPerson: String?,
    val club: String,
    val isCelebrity: String,
    val country: CountryApi
)
