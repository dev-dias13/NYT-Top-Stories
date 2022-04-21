package org.devdias.nyttopstories.model.movies


import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val moviesResults: List<MoviesResult>,
    @SerializedName("section")
    val section: String,
    @SerializedName("status")
    val status: String
)