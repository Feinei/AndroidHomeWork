package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reset_pass.*

class ResetPassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_pass)

        new_pass_button.setOnClickListener {
            PasswordRepository.password = et_new_pass.editableText.toString()
            onBackPressed()
        }
    }
}
