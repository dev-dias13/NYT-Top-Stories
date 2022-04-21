package org.devdias.nyttopstories.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.devdias.nyttopstories.model.fashion.FashionResponse
import org.devdias.nyttopstories.repo.StoriesRepo
import org.devdias.nyttopstories.util.Status
import javax.inject.Inject

@HiltViewModel
class FashionViewModel @Inject constructor(
    private val storiesRepo: StoriesRepo
): ViewModel() {

    var isLoading = mutableStateOf(false)
    private var _getData: MutableLiveData<FashionResponse> = MutableLiveData<FashionResponse>()
    var getData: LiveData<FashionResponse> = _getData

    suspend fun getFashionData(): Status<FashionResponse> {
        val result = storiesRepo.getFashionResponse()
        if (result is Status.Success) {
            isLoading.value = true
            _getData.value = result.data!!
        }

        return result
    }
}