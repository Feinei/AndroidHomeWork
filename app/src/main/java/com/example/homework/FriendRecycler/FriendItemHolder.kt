package com.example.homework.FriendRecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_friend.*

class FriendItemHolder(
    override val containerView: View,
    private val clickLambda: (Friend) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    companion object {
        fun create(parent: ViewGroup, clickLambda: (Friend) -> Unit) =
            FriendItemHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_friend, parent, false),
                clickLambda
            )
    }

    fun bind(friend: Friend) {
        tv_friend_name.text = friend.name
        tv_friend_type.text = friend.friendType

        itemView.setOnClickListener {
            clickLambda(friend)
        }
    }
}
