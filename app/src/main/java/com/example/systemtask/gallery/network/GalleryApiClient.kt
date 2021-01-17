package com.example.systemtask.gallery.network

import androidx.viewbinding.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GalleryApiClient {

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG)
                level = HttpLoggingInterceptor.Level.BODY
            else
                level = HttpLoggingInterceptor.Level.BASIC
        }).build()

    private val retofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/AdnanTheEntertainer/StackOverflowQuestions/master/")
            .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
            .build()

    fun <T>buildService(service: Class<T>) : T {
        return  retofit.create(service)
    }
}