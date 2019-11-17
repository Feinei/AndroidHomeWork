package com.example.homework.PicGalleryRecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.example.homework.R
import kotlinx.android.synthetic.main.pic_holder.view.*

class PicsPagerAdapter(context: Context, picsId: List<Int>) : PagerAdapter() {

    private val picGallery = picsId

    private val mLayoutInflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int = picGallery.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view === `object` as ConstraintLayout

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val itemView = mLayoutInflater.inflate(R.layout.pic_holder, container, false)
        itemView.iv_pic_hold.setImageResource(picGallery[position])
        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) =
        container.removeView(`object` as ConstraintLayout)
}
