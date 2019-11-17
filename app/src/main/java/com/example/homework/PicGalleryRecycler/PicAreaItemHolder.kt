package com.example.homework.PicGalleryRecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_pic_area.*

class PicAreaItemHolder(
    private val context: Context,
    override val containerView: View,
    private val clickLambda: (PicArea) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    companion object {
        fun create(parent: ViewGroup, clickLambda: (PicArea) -> Unit) =
            PicAreaItemHolder(
                parent.context,
                LayoutInflater.from(parent.context).inflate(R.layout.item_pic_area, parent, false),
                clickLambda
            )
    }

    fun bind(picArea: PicArea) {
        view_avatar.setImageDrawable(context.getDrawable(picArea.avatarId))
        tv_account_name.text = picArea.name
        tv_description.text = picArea.descrption

        vp_pics.adapter = PicsPagerAdapter(context, picArea.picsId)
        vp_pics.currentItem = 0

        itemView.setOnClickListener {
            clickLambda(picArea)
        }
    }
}
