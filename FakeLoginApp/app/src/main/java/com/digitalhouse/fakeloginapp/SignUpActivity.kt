package com.digitalhouse.fakeloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.digitalhouse.fakeloginapp.users.UserService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        login_page.setOnClickListener {
            finish()
        }

        signup_privacy_checkBox.setOnCheckedChangeListener { _, isChecked ->
            signup_button.isEnabled = isChecked
        }

        signup_button.setOnClickListener {
            val name = signup_name.text.toString()
            val email = signup_email.text.toString()
            val password = signup_password.text.toString()

            if (name.isEmpty()) {
                signup_name.error = "Campo Vazio"
            } else if (email.isEmpty()) {
                signup_email.error = "Campo Vazio"
            } else if (password.isEmpty()) {
                signup_password.error = "Campo Vazio"
            } else {
                try {
                    UserService.register(name, email, password)
                    Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_LONG).show()
                    finish()
                } catch (e: Exception) {
                    Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
                }
            }

        }
    }
}