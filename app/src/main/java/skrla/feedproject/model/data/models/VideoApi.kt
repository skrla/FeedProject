package skrla.feedproject.model.data.models

import com.google.gson.annotations.SerializedName

data class VideoApi(
    val handler: String,
    @SerializedName("url") val videoUrl: String,
    @SerializedName("poster") val picOfMoment: String,
    val type: String,
    val length: Int
)
