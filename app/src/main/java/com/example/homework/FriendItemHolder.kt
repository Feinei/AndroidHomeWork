package com.example.homework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_friend.*

class FriendItemHolder(
    override val containerView: View,
    private val clickLambda: (Friend) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(friend: Friend) {
        tv_name.text = friend.name
        tv_friend_type.text = friend.friendType
        iv_avatar.setImageDrawable(friend.avatar)

        itemView.setOnClickListener {
            clickLambda(friend)
        }
    }

    companion object {

        fun create(parent: ViewGroup, clickLambda: (Friend) -> Unit) =
            FriendItemHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_friend, parent, false),
                clickLambda
            )
    }
}