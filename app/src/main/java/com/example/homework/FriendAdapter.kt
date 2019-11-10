package com.example.homework

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class FriendAdapter(
    private var dataSource: List<Friend>,
    private val clickLambda: (Friend) -> Unit
) : RecyclerView.Adapter<FriendItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendItemHolder =
        FriendItemHolder.create(parent, clickLambda)

    override fun getItemCount(): Int = dataSource.size

    override fun onBindViewHolder(holder: FriendItemHolder, position: Int) =
        holder.bind(dataSource[position])
}
