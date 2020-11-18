package com.caioal.exercicologinapp

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignInFragment : Fragment() {

    private lateinit var changeTabListener: IChangeTab
    private lateinit var myView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myView = inflater.inflate(R.layout.fragment_sign_in, container, false)

        myView.findViewById<MaterialButton>(R.id.btnLogIn).setOnClickListener {
            if (checkFieldsSignIn(myView)) {
                Toast.makeText(myView.context, "Login realizado", Toast.LENGTH_LONG).show()
            }
        }

        myView.findViewById<TextInputEditText>(R.id.edtTxtUsernameSignIn).addTextChangedListener(object :
            TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                myView.findViewById<TextInputLayout>(R.id.txtUsernameSignIn).error = ""
            }
        })

        myView.findViewById<TextInputEditText>(R.id.edtTxtPasswordSignIn).addTextChangedListener(object :
            TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                myView.findViewById<TextInputLayout>(R.id.txtPasswordSignIn).error = ""
            }
        })

        return myView

    }

    fun checkFieldsSignIn(view: View): Boolean {
        var resultado = true

        val edtUserName = view.findViewById<TextInputEditText>(R.id.edtTxtUsernameSignIn)
        val edtPassword = view.findViewById<TextInputEditText>(R.id.edtTxtPasswordSignIn)

        if (edtUserName.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtUsernameSignIn).error = "Username Vazio"
            resultado = false
        }

        if (edtPassword.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtPasswordSignIn).error = "Password Vazio"
            resultado = false
        }

        return resultado
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        changeTabListener = context as IChangeTab
    }


    fun userNameChanged(username: String) {
        val edtUserName = myView.findViewById<TextInputEditText>(R.id.edtTxtUsernameSignIn)
        edtUserName.setText(username)
        val edtPassword = myView.findViewById<TextInputEditText>(R.id.edtTxtPasswordSignIn)
        edtPassword.setText("")
        edtPassword.requestFocus()
    }
}