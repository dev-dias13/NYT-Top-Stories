package org.devdias.nyttopstories.model.arts


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Stories(
    @Json(name = "copyright")
    val copyright: String,
    @Json(name = "last_updated")
    val lastUpdated: String,
    @Json(name = "num_results")
    val numResults: Int,
    @Json(name = "results")
    val results: List<Result>,
    @Json(name = "section")
    val section: String,
    @Json(name = "status")
    val status: String
)