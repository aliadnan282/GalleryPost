package com.example.systemtask.gallery.model

sealed class ResponseState<out T> {
    data class LOADING (val loading: Boolean): ResponseState<Nothing>()
    data class SUCCESS<T> (val data: T): ResponseState<T>()
    data class ERROR (val error: String?): ResponseState<Nothing>()

    override fun toString(): String {
       return when(this) {
           is LOADING -> "Loading [$loading]"
           is SUCCESS -> "Success [data=$data]"
           is ERROR -> "Error [error=$error]"
       }
    }
}