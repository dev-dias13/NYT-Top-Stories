package org.devdias.nyttopstories.repo

import dagger.hilt.android.scopes.ActivityScoped
import org.devdias.nyttopstories.model.arts.Stories
import org.devdias.nyttopstories.model.fashion.FashionResponse
import org.devdias.nyttopstories.model.movies.MoviesResponse
import org.devdias.nyttopstories.model.tech.TechResponse
import org.devdias.nyttopstories.remote.APIInterface
import org.devdias.nyttopstories.util.Status
import javax.inject.Inject

@ActivityScoped
class StoriesRepo @Inject constructor(
    private val apiInterface: APIInterface
) {
    //Arts
    suspend fun getArtsResponse(): Status<Stories> {
        val response = try {
            apiInterface.getArtsPosts()
        } catch (e: Exception) {
            return Status.Error("An unknown error occured: ${e.localizedMessage}")
        }

        return Status.Success(response)
    }
    //Tech
    suspend fun getTechResponse(): Status<TechResponse> {
        val response = try {
            apiInterface.getTechPosts()
        } catch (e: Exception) {
            return Status.Error("An unknown error occured: ${e.localizedMessage}")
        }

        return Status.Success(response)
    }
    //Fashion
    suspend fun getFashionResponse(): Status<FashionResponse> {
        val response = try {
            apiInterface.getFashionPosts()
        } catch (e: Exception) {
            return Status.Error("An unknown error occured: ${e.localizedMessage}")
        }

        return Status.Success(response)
    }

    //Movies
    suspend fun getMoviesResponse(): Status<MoviesResponse> {
        val response = try {
            apiInterface.getMoviesPosts()
        } catch (e: Exception) {
            return Status.Error("An unknown error occured: ${e.localizedMessage}")
        }

        return Status.Success(response)
    }
}