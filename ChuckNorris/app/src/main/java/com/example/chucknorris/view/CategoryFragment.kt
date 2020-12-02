package com.example.chucknorris.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorris.R
import com.example.chucknorris.repository.CategoryRepository
import com.example.chucknorris.viewModel.CategoryViewModel


class CategoryFragment : Fragment() {

    lateinit var _viewModel: CategoryViewModel

    lateinit var _view: View
    private lateinit var _categoryList: MutableList<String>
    private lateinit var _listaAdapter: CategoryAdapter
    private val recycler = view?.findViewById<RecyclerView>(R.id.rcyVw)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    _view = view
        val manager = LinearLayoutManager(view.context)

        _categoryList = mutableListOf<String>()
        _listaAdapter = CategoryAdapter(_categoryList)

        recycler?.apply {
            setHasFixedSize(true)

            layoutManager = manager
            adapter = _listaAdapter
        }

        _viewModel = ViewModelProvider(
            this,
            CategoryViewModel.CategoryViewModelFactory(CategoryRepository())
        ).get(CategoryViewModel::class.java)

        _viewModel.getCategories().observe(viewLifecycleOwner, {
            showResults(it)
        })

    }

    private fun showResults(categories: List<String>) {
        _categoryList.addAll(categories)

        _listaAdapter.notifyDataSetChanged()
    }

}