package com.example.homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start_sending_activity.setOnClickListener {
            startActivity(Intent(this, SendingActivity::class.java))
        }

        btn_start_getting_activity.setOnClickListener {
            val sendTextIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "I need to reach in GettingActivity")
                type = "text/plain"
            }
            startActivity(sendTextIntent)
        }
    }
}
