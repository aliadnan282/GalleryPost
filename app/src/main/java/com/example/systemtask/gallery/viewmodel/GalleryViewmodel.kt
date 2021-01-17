package com.example.systemtask.gallery.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.systemtask.gallery.model.ImageResponse
import com.example.systemtask.gallery.model.ResponseState
import com.example.systemtask.gallery.repository.GalleryRepository
import kotlinx.coroutines.launch

class GalleryViewmodel @ViewModelInject constructor(
    val repository: GalleryRepository,
    @Assisted private val savedStateHandle: SavedStateHandle

) : ViewModel() {
    private var _images = MutableLiveData<ResponseState<ImageResponse>>()
    val images: LiveData<ResponseState<ImageResponse>> = _images

    fun getImages() {
        viewModelScope.launch {
            _images.postValue(ResponseState.LOADING(true))
            val response = repository.getImages()
            if (response.isSuccessful) {
                _images.postValue(ResponseState.SUCCESS(response.body() as ImageResponse))
            } else if (response.isSuccessful.not())
                _images.postValue(ResponseState.ERROR(response.body().toString()))

        }
    }
}