package com.example.homework.FriendRecycler

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kotlinx.android.synthetic.main.item_friend.*

class FriendListAdapter(
    private val itemClickLambda: (Friend) -> Unit
) : ListAdapter<Friend, FriendItemHolder>(object : DiffUtil.ItemCallback<Friend>() {

    override fun areItemsTheSame(oldItem: Friend, newItem: Friend): Boolean = oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: Friend, newItem: Friend): Boolean = oldItem == newItem
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendItemHolder =
        FriendItemHolder.create(parent, itemClickLambda)

    override fun onBindViewHolder(holder: FriendItemHolder, position: Int) {
        holder.iv_delete_item.setOnClickListener {
            FriendsRepository.removeItem(position)
            this.submitList(FriendsRepository.getDataSource())
        }
        holder.bind(getItem(position))
    }
}
