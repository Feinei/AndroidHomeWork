package com.example.homework

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class SongAdapter(
    private val itemClickLambda: (Song) -> Unit
) : ListAdapter<Song, SongItemHolder>(object : DiffUtil.ItemCallback<Song>() {

    override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean = oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean = oldItem == newItem
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongItemHolder =
        SongItemHolder.create(parent, itemClickLambda)

    override fun onBindViewHolder(holder: SongItemHolder, position: Int) = holder.bind(getItem(position))
}
