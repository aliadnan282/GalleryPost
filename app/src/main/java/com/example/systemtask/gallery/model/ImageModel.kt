package com.example.systemtask.gallery.model


data class ImageModel(
    var id: Int = 1,
    var title: String? = null,
    var url: String? = null,
    var thumbnailUrl: String? = null
)