package com.example.homework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.homework.FriendRecycler.Friend
import com.example.homework.FriendRecycler.FriendsRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    FriendListFragment.OnRecyclerFragmentListener,
    AddFriendDialog.DialogListener {

    companion object {
        private const val DEFAULT_FRAGMENT_TAG = "default"
        private const val RECYCLER_FRAGMENT_TAG = "recycler_frag"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bnv_main.setOnNavigationItemReselectedListener {
            var tag: String? = DEFAULT_FRAGMENT_TAG
            var fragment: Fragment = when (it.itemId) {
                R.id.navigation_first -> UselessFragment.newInstance()
                R.id.navigation_sec -> {
                    tag = RECYCLER_FRAGMENT_TAG
                    FriendListFragment.newInstance()
                }
                R.id.navigation_third -> PicGalleryFragment.newInstance()
                else -> UselessFragment.newInstance()
            }
            fragment?.let { currentFragment ->
                supportFragmentManager.beginTransaction().replace(R.id.container_main, currentFragment, tag).commit()
            }
        }
    }

    override fun onRecyclerFragment() {
        AddFriendDialog().show(supportFragmentManager.beginTransaction(), null)
    }

    override fun onFinishEditDialog(name: String, friendType: String, position: Int) {
        FriendsRepository.add(Friend(name, friendType), position)
        (supportFragmentManager.findFragmentByTag(RECYCLER_FRAGMENT_TAG) as FriendListFragment)
            .updateRecycler(FriendsRepository.getDataSource())
    }
}
