package skrla.feedprocject.model.data.models

import com.google.gson.annotations.SerializedName

data class AthleteApi(
    val id: Int,
    val age: Int,
    val name: String,
    @SerializedName("avatar") val picOfPerson: String,
    val club: String,
    val isCelebrity: Boolean
)
