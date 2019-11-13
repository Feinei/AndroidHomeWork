package com.example.homework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_member.*

class MemberFragment : Fragment() {

    private var listener: OnMemberFragmentInteractionListener? = null

    companion object {
        fun newInstance(): MemberFragment = MemberFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnMemberFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnMemberFragmentInteractionListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_member, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_join.setOnClickListener {
            listener?.onMemberFragmentInteraction()
        }
    }

    interface OnMemberFragmentInteractionListener {
        fun onMemberFragmentInteraction()
    }
}
