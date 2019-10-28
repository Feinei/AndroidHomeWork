package com.example.homework

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val name = intent?.extras?.getString(KEY_NAME) ?: "Unknown"
        val friendType = intent?.extras?.getString(KEY_FRIEND_TYPE) ?: "Unknown"
        tv_name.text = name
        tv_friend_type.text = friendType
    }

    companion object {
        private const val KEY_NAME = "friendName"
        private const val KEY_FRIEND_TYPE = "friendType"

        fun createIntent(activity: Activity, friend: Friend) =
            Intent(activity, AboutActivity::class.java).apply {
                putExtra(KEY_NAME, friend.name)
                putExtra(KEY_FRIEND_TYPE, friend.friendType)
            }
    }
}
