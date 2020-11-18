package com.caioal.exercicologinapp

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class SignUpFragment : Fragment() {

    private lateinit var changeTabListener: IChangeTab
    private lateinit var myView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myView = inflater.inflate(R.layout.fragment_sign_up, container, false)
        val txtEditUserName = myView.findViewById<TextInputEditText>(R.id.edtTxtUsernameSignUp)

        myView.findViewById<MaterialButton>(R.id.btnSignUp).setOnClickListener {
            if (checkFieldsSignUp(myView)) {
                Toast.makeText(myView.context, "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show()
                Handler(Looper.getMainLooper()).postDelayed({
                    changeTabListener.changeTab(SIGNUP_FRAGMENT)
                    changeTabListener.userNameChanged(txtEditUserName.text.toString())
                }, 2000)
            }
        }

        myView.findViewById<TextInputEditText>(R.id.edtTxtUsernameSignUp).addTextChangedListener(object :
            TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                myView.findViewById<TextInputLayout>(R.id.txtUsernameSignUp).error = ""
            }
        })

        myView.findViewById<TextInputEditText>(R.id.edtTxtPasswordSignUp).addTextChangedListener(object :
            TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                myView.findViewById<TextInputLayout>(R.id.txtPasswordSignUp).error = ""
            }
        })


        myView.findViewById<TextInputEditText>(R.id.edtTxtPasswordConfirmSignUp).addTextChangedListener(object :
            TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                myView.findViewById<TextInputLayout>(R.id.txtPasswordConfirmSignUp).error = ""
            }
        })

        val chkAgree = myView.findViewById<CheckBox>(R.id.chkAgree)
        val btnSignUp = myView.findViewById<MaterialButton>(R.id.btnSignUp)

        chkAgree.setOnClickListener {
            btnSignUp.isEnabled = chkAgree.isChecked == true
        }

        return myView
    }

    fun checkFieldsSignUp(view: View): Boolean {
        var resultado = true

        val edtUserName = view.findViewById<TextInputEditText>(R.id.edtTxtUsernameSignUp)
        val edtPassword = view.findViewById<TextInputEditText>(R.id.edtTxtPasswordSignUp)
        val edtConfirmPassword = view.findViewById<TextInputEditText>(R.id.edtTxtPasswordConfirmSignUp)

        if (edtUserName.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtUsernameSignUp).error = "Username Vazio"
            resultado = false
        }

        if (edtPassword.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtPasswordSignUp).error = "Password Vazio"
            resultado = false
        } else if (edtPassword.text.toString().length < 8) {
            view.findViewById<TextInputLayout>(R.id.txtPasswordSignUp).error = "Senha deve conter no mínimo 8 caracteres"
            resultado = false
        }

        if (edtConfirmPassword.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtPasswordConfirmSignUp).error = "Password Vazio"
            resultado = false
        } else if (edtConfirmPassword.text.toString() != edtPassword.text.toString()) {
            view.findViewById<TextInputLayout>(R.id.txtPasswordConfirmSignUp).error = "O campo Confirmar senha deve ser igual ao campo Senha. ${edtConfirmPassword.text} n ${edtPassword.text}"
            resultado = false
        }



        return resultado
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        changeTabListener = context as IChangeTab
    }

}