package org.devdias.nyttopstories.model.arts


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
    @Json(name = "abstract")
    val `abstract`: String,
    @Json(name = "byline")
    val byline: String,
    @Json(name = "created_date")
    val createdDate: String,
    @Json(name = "des_facet")
    val desFacet: List<String>,
    @Json(name = "geo_facet")
    val geoFacet: List<String>,
    @Json(name = "item_type")
    val itemType: String,
    @Json(name = "kicker")
    val kicker: String,
    @Json(name = "material_type_facet")
    val materialTypeFacet: String,
    @Json(name = "multimedia")
    val multimedia: List<Multimedia>,
    @Json(name = "org_facet")
    val orgFacet: List<String>,
    @Json(name = "per_facet")
    val perFacet: List<String>,
    @Json(name = "published_date")
    val publishedDate: String,
    @Json(name = "section")
    val section: String,
    @Json(name = "short_url")
    val shortUrl: String,
    @Json(name = "subsection")
    val subsection: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "updated_date")
    val updatedDate: String,
    @Json(name = "uri")
    val uri: String,
    @Json(name = "url")
    val url: String
)