package com.example.systemtask.gallery

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GalleryApp: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}