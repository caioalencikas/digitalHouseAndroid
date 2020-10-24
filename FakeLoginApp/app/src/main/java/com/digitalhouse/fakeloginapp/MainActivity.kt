package com.digitalhouse.fakeloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.digitalhouse.fakeloginapp.users.UserService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        create_account_page.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        if (txtLoginEmail != null && txtLoginPassword != null) {
            btnLoginLogin.isEnabled = true
        }

        btnLoginLogin.setOnClickListener{
            val email = txtLoginEmail.text.toString()
            val password = txtLoginPassword.text.toString()

            if(UserService.logIn(email, password) != null) {
                val intent = Intent(this, activity_welcome::class.java)
                intent.putExtra("USERNAME", UserService.logIn(email, password)?.name)
                startActivity(intent)
                finish()
            }
        }

    }
}