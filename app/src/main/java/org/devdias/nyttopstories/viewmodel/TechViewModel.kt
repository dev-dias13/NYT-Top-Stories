package org.devdias.nyttopstories.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.devdias.nyttopstories.model.tech.TechResponse
import org.devdias.nyttopstories.repo.StoriesRepo
import org.devdias.nyttopstories.util.Status
import javax.inject.Inject

@HiltViewModel
class TechViewModel @Inject constructor(
    private val storiesRepo: StoriesRepo
): ViewModel() {

    var isLoading = mutableStateOf(false)
    private var _getData: MutableLiveData<TechResponse> = MutableLiveData<TechResponse>()
    var getData: LiveData<TechResponse> = _getData

    suspend fun getTechData(): Status<TechResponse> {
        val result = storiesRepo.getTechResponse()
        if (result is Status.Success) {
            isLoading.value = true
            _getData.value = result.data!!
        }

        return result
    }
}