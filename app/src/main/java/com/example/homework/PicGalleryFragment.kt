package com.example.homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.homework.PicGalleryRecycler.PicAreaListAdapter
import com.example.homework.PicGalleryRecycler.PicGalleryRepository
import kotlinx.android.synthetic.main.fragment_pic_gallery.*

class PicGalleryFragment : Fragment() {

    companion object {
        fun newInstance(): PicGalleryFragment = PicGalleryFragment()
    }

    private val adapter = PicAreaListAdapter {
        Toast.makeText(this.context, "тык на пост", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_pic_gallery, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.submitList(PicGalleryRepository.getDataSource())
        rv_pics.adapter = adapter
    }
}
