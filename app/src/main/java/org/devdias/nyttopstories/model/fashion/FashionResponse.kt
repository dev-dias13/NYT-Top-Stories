package org.devdias.nyttopstories.model.fashion


import com.google.gson.annotations.SerializedName

data class FashionResponse(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val fashionResults: List<FashionResult>,
    @SerializedName("section")
    val section: String,
    @SerializedName("status")
    val status: String
)