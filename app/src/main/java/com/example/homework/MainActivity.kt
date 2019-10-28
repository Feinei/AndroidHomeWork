package com.example.homework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var adapter: FriendAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = FriendAdapter(getDataSource()) { friend ->
            navigateToAbout(friend)
        }

        rv_friends.adapter = adapter
    }

    private fun navigateToAbout(friend: Friend) {
        startActivity(AboutActivity.createIntent(this, friend))
    }

    private fun getDataSource(): List<Friend> = listOf(
        Friend("i", "Best Friend", getDrawable(R.drawable.i)),
        Friend("You", "Best friend", getDrawable(R.drawable.you)),
        Friend("Leonardo", "Boyfriend", getDrawable(R.drawable.leo)),
        Friend("Edward", "Friend", getDrawable(R.drawable.edward)),
        Friend("Justin", "Friend", getDrawable(R.drawable.justin)),
        Friend("Edward", "Friend", getDrawable(R.drawable.edward)),
        Friend("Justin", "Friend", getDrawable(R.drawable.justin)),
        Friend("Edward", "Friend", getDrawable(R.drawable.edward)),
        Friend("Justin", "Friend", getDrawable(R.drawable.justin)),
        Friend("Edward", "Friend", getDrawable(R.drawable.edward)),
        Friend("Justin", "Friend", getDrawable(R.drawable.justin)),
        Friend("Edward", "Friend", getDrawable(R.drawable.edward)),
        Friend("Justin", "Friend", getDrawable(R.drawable.justin))
    )
}
