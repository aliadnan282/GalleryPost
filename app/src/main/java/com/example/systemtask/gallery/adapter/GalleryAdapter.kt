package com.example.systemtask.gallery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.systemtask.databinding.ItemGalleryBinding
import com.example.systemtask.gallery.model.ImageModel

class GalleryAdapter(var itemList: List<ImageModel>? = listOf(), var onclick: (ImageModel?) -> Unit) : RecyclerView.Adapter<GalleryAdapter.GalleryVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryVH {
        return GalleryVH(
            ItemGalleryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    fun setData(list: List<ImageModel>?){
        this.itemList = list
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: GalleryVH, position: Int) {
        holder.bind(itemList?.get(position))
    }

    override fun getItemCount(): Int {
        return itemList?.size ?: 0
    }

    inner class GalleryVH(val binding: ItemGalleryBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: ImageModel?) {
            binding.root.setOnClickListener{
                onclick(item)
            }
            binding.tvTitle.text = "${item?.id}-${item?.title}"
            Glide.with(binding.ivThumnail.context)
                .load(item?.url+".png")
                .into(binding.ivThumnail)

        }
    }
}