package com.example.homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.homework.FriendRecycler.FriendsRepository
import kotlinx.android.synthetic.main.fragment_friend_dialog.*

class AddFriendDialog : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_friend_dialog, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_add_friend.setOnClickListener {

            var position: Int = if (et_position.text.toString() != "")
                et_position.text.toString().toInt()
            else
                FriendsRepository.getDataSource().count()

            (activity as DialogListener).onFinishEditDialog(
                et_name.text.toString(),
                et_friend_type.text.toString(),
                position
            )
            dismiss()
        }
    }

    interface DialogListener {
        fun onFinishEditDialog(name: String, friendType: String, position: Int)
    }
}
