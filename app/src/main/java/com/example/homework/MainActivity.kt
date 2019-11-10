package com.example.homework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_friends.adapter = FriendAdapter(getDataSource()) {
            startActivity(AboutActivity.createIntent(this, it))
        }
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
