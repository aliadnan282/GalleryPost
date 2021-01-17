package com.example.systemtask.gallery.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.systemtask.R
import com.example.systemtask.databinding.FragmentGalleryBinding
import com.example.systemtask.gallery.adapter.GalleryAdapter
import com.example.systemtask.gallery.model.ResponseState
import com.example.systemtask.gallery.viewmodel.GalleryViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment : Fragment() {
    private var _binding: FragmentGalleryBinding? = null
    private var galleryAdapter: GalleryAdapter? = null
    private val viewmodel: GalleryViewmodel by activityViewModels()
    private val binding get() = _binding

    companion object {
        fun newInstance(): GalleryFragment {
            val args = Bundle()
            val fragment = GalleryFragment()
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGalleryBinding.inflate(layoutInflater, container, false)
        setupViews()
        return _binding?.root
    }

    private fun setupViews() {
        galleryAdapter = GalleryAdapter(listOf()){
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container_view, DetailFragment(), bundleOf("id" to "value").toString() )
            }
        }
        binding?.rvGallery?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = galleryAdapter
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null)
        viewmodel.getImages()
        viewmodel.images.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ResponseState.LOADING ->
                    binding?.pbLoading?.visibility = View.VISIBLE
                is ResponseState.SUCCESS -> {
                    binding?.pbLoading?.visibility = View.GONE
                    galleryAdapter?.setData(it.data.data)
                }
                is ResponseState.ERROR -> {
                    binding?.pbLoading?.visibility = View.GONE
                }
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}