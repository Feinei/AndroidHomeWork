package com.example.homework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_join.*

class JoinFragment : Fragment() {

    private var listener: OnJoinFragmentInteractionListener? = null

    companion object {
        fun newInstance(): JoinFragment = JoinFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnJoinFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnJoinFragmentInteractionListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_join, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_join_with_data.setOnClickListener {
            listener?.onJoinFragmentInteraction()
        }
    }

    interface OnJoinFragmentInteractionListener {
        fun onJoinFragmentInteraction()
    }
}
