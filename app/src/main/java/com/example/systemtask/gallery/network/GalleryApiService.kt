package com.example.systemtask.gallery.network

import com.example.systemtask.gallery.model.ImageModel
import com.example.systemtask.gallery.model.ImageResponse
import retrofit2.Response
import retrofit2.http.GET

interface GalleryApiService {

    @GET("images.json")
    suspend fun getImages(): Response<ImageResponse>
}