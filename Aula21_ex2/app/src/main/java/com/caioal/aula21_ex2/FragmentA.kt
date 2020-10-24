package com.caioal.aula21_ex2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_a.*
import kotlinx.android.synthetic.main.fragment_b.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentA.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentA : Fragment(), ICalcular {

        private lateinit var activity: ICalcular

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ICalcular) activity = context
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCalcular.setOnClickListener {
            if (edtTxtNome.text?.isEmpty()!!) {
                edtTxtNome.error = getString(R.string.inserirNome)
            } else if (edtTxtAno.text?.isEmpty()!!) {
                edtTxtAno.error = getString(R.string.inserirIdade)
            } else {
                val nome = edtTxtNome.text?.toString()
                val ano = edtTxtAno.text?.toString()?.toInt()
                activity.calcular(nome!!, ano!!)
            }
        }


    }


}