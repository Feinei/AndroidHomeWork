package com.example.homework.PicGalleryRecycler

import com.example.homework.R

class PicGalleryRepository {

    companion object {

        private const val picId: Int = R.drawable.man

        fun getDataSource(): List<PicArea> = dataSource

        private val dataSource: List<PicArea> = listOf(
            PicArea(picId, "Askar", generateSequence { picId }.take(2).toList(), "aaaaaaa"),
            PicArea(picId, "Abby", generateSequence { picId }.take(3).toList(), "bbbbbb"),
            PicArea(picId, "Carl", generateSequence { picId }.take(4).toList(), "ccccc"),
            PicArea(picId, "Sonya", generateSequence { picId }.take(5).toList(), "ddddd"),
            PicArea(picId, "Marcula", generateSequence { picId }.take(5).toList(), "eeeee"),
            PicArea(picId, "Bubuin", generateSequence { picId }.take(5).toList(), "aaaaaaa")
        )
    }
}
