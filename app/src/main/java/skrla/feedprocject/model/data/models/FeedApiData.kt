package skrla.feedprocject.model.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class FeedApiData(
    val id: String,
    val createdAt: Date,
    val createdBefore: String,
    val description: String,
    val bookmarked: String,
    val views: String
) : Parcelable
