package org.devdias.nyttopstories.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.devdias.nyttopstories.model.arts.Stories
import org.devdias.nyttopstories.repo.StoriesRepo
import org.devdias.nyttopstories.util.Status
import javax.inject.Inject

@HiltViewModel
class ArtsViewModel @Inject constructor(
    private val storiesRepo: StoriesRepo
): ViewModel() {

    var isLoading = mutableStateOf(false)
    private var _getData: MutableLiveData<Stories> = MutableLiveData<Stories>()
    var getData: LiveData<Stories> = _getData

    suspend fun getArtsData(): Status<Stories> {
        val result = storiesRepo.getArtsResponse()
        if (result is Status.Success) {
            isLoading.value = true
            _getData.value = result.data!!
        }

        return result
    }
}