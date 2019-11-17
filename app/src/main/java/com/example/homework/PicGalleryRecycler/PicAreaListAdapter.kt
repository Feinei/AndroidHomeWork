package com.example.homework.PicGalleryRecycler

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class PicAreaListAdapter(
    private val itemClickLambda: (PicArea) -> Unit
) : ListAdapter<PicArea, PicAreaItemHolder>(object : DiffUtil.ItemCallback<PicArea>() {

    override fun areItemsTheSame(oldItem: PicArea, newItem: PicArea): Boolean = oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: PicArea, newItem: PicArea): Boolean = oldItem == newItem
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicAreaItemHolder =
        PicAreaItemHolder.create(parent, itemClickLambda)

    override fun onBindViewHolder(holder: PicAreaItemHolder, position: Int) = holder.bind(getItem(position))
}
