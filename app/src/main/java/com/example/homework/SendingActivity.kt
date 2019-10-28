package com.example.homework

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sending.*

class SendingActivity : AppCompatActivity() {

    companion object {
        private const val PICKFILE_RESULT_CODE = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sending)

        btn_send_intent.setOnClickListener {

            val searchIntent = Intent().apply {
                action = Intent.ACTION_GET_CONTENT
                type = "file/*"
            }
            startActivityForResult(searchIntent, PICKFILE_RESULT_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            PICKFILE_RESULT_CODE -> if (resultCode === Activity.RESULT_OK) {
                Toast.makeText(this, data?.data?.path, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
