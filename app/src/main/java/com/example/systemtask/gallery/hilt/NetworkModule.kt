package com.example.systemtask.gallery.hilt

import com.example.systemtask.BuildConfig
import com.example.systemtask.gallery.network.GalleryApiService
import com.example.systemtask.gallery.repository.GalleryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG)
                level = HttpLoggingInterceptor.Level.BODY
            else
                level = HttpLoggingInterceptor.Level.BASIC
        })
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient) = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/AdnanTheEntertainer/StackOverflowQuestions/master/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideGalleryService(retrofit: Retrofit) = retrofit.create(GalleryApiService::class.java)

    @Provides
    @Singleton
    fun provideRepository(service: GalleryApiService) = GalleryRepository(service)

}