package org.devdias.nyttopstories.remote

import org.devdias.nyttopstories.model.arts.Stories
import org.devdias.nyttopstories.model.fashion.FashionResponse
import org.devdias.nyttopstories.model.movies.MoviesResponse
import org.devdias.nyttopstories.model.tech.TechResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface APIInterface {
    //Arts
    @GET("{section}.json")
    suspend fun getArtsPosts(
        @Path("section", encoded=true) section: String = "arts",
        @Query("api-key", encoded=true) api: String = HttpRoutes.API_KEY,): Stories

    //Tech
    @GET("{section}.json")
    suspend fun getTechPosts(
        @Path("section", encoded=true) section: String = "technology",
        @Query("api-key", encoded=true) api: String = HttpRoutes.API_KEY,): TechResponse

    //Science
    @GET("{section}.json")
    suspend fun getFashionPosts(
        @Path("section", encoded=true) section: String = "fashion",
        @Query("api-key", encoded=true) api: String = HttpRoutes.API_KEY,): FashionResponse

    //Movies
    @GET("{section}.json")
    suspend fun getMoviesPosts(
        @Path("section", encoded=true) section: String = "movies",
        @Query("api-key", encoded=true) api: String = HttpRoutes.API_KEY,): MoviesResponse
}