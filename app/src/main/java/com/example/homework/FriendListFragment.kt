package com.example.homework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.homework.FriendRecycler.Friend
import com.example.homework.FriendRecycler.FriendListAdapter
import com.example.homework.FriendRecycler.FriendsRepository
import kotlinx.android.synthetic.main.fragment_friendlist.*

class FriendListFragment : Fragment() {

    companion object {
        fun newInstance(): FriendListFragment = FriendListFragment()
    }

    private var listener: OnRecyclerFragmentListener? = null

    private val adapter = FriendListAdapter {
        Toast.makeText(this.context, "тык на друга", Toast.LENGTH_SHORT).show()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnRecyclerFragmentListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnRecyclerFragmentListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_friendlist, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.submitList(FriendsRepository.getDataSource())
        rv_friends.adapter = adapter

        btn_open_friend_dialog.setOnClickListener {
            listener?.onRecyclerFragment()
        }
    }

    fun updateRecycler(newList: List<Friend>) {
        adapter.submitList(newList)
    }

    interface OnRecyclerFragmentListener {
        fun onRecyclerFragment()
    }
}
