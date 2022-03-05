package skrla.feedprocject.model.data.models

import com.google.gson.annotations.SerializedName

data class SportApi(
    val id: String,
    val slug: String,
    val name: String,
    @SerializedName("icon") val picOfBall: String
)
