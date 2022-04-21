package org.devdias.nyttopstories.model.tech


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TechResponse(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val techResults: List<TechResult>,
    @SerializedName("section")
    val section: String,
    @SerializedName("status")
    val status: String
)