package com.example.systemtask.gallery.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import com.example.systemtask.R
import com.example.systemtask.databinding.ActivityGalleryBinding
import com.example.systemtask.gallery.fragment.GalleryFragment
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryActivity: AppCompatActivity() {
    private var binding: ActivityGalleryBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null ){
            val bundle = bundleOf("id" to 1)
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container_view, GalleryFragment(),  "bundle")
            }
        }
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }
}