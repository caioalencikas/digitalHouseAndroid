package com.caioal.aula24

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


/**
 * A simple [Fragment] subclass.
 * Use the [MeuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MeuFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString("TEXTO")
            param2 = it.getBoolean("MAIOR DE IDADE")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_meu, container, false)
        view.findViewById<TextView>(R.id.txtView).text = param1

        return view
    }

    companion object {
        fun newInstance(texto: String, maiorDeIdade: Boolean) =
            MeuFragment().apply {
                arguments = Bundle().apply {
                    putString("TEXTO", texto)
                    putBoolean("MAIOR DE IDADE", maiorDeIdade)
                }
            }
    }
}