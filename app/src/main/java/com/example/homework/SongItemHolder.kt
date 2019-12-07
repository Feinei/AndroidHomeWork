package com.example.homework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_song.*

class SongItemHolder(
    override val containerView: View,
    private val clickLambda: (Song) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    companion object {
        fun create(parent: ViewGroup, clickLambda: (Song) -> Unit) =
            SongItemHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false),
                clickLambda
            )
    }

    fun bind(song: Song) {
        tv_song.text = song.name
        tv_artist.text = song.artist
        iv_cover.setImageResource(song.coverId)

        itemView.setOnClickListener {
            clickLambda(song)
        }
    }
}
