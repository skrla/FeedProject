package skrla.feedprocject.model.data.models

import java.util.*

data class FeedApiData(
    val id: String,
    val createdAt: Date,
    val createdBefore: String,
    val author: AuthorApi,
    val sportGroup: SportGroupApi,
    val video: VideoApi,
    val description: String,
    val athlete: AthleteApi,
    val bookmarked: String,
    val views: String
)
