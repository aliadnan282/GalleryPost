package com.example.systemtask.gallery.repository

import com.example.systemtask.gallery.model.ImageModel
import com.example.systemtask.gallery.model.ImageResponse
import com.example.systemtask.gallery.network.GalleryApiClient
import com.example.systemtask.gallery.network.GalleryApiService
import retrofit2.Response
import javax.inject.Inject

class GalleryRepository @Inject constructor(
    val client: GalleryApiService
){
//    val client = GalleryApiClient.buildService(GalleryApiService::class.java)
    suspend fun getImages() : Response<ImageResponse>{
    return client.getImages()
    }
}