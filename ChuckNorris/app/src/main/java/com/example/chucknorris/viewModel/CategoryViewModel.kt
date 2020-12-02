package com.example.chucknorris.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.chucknorris.model.CategoryModel
import com.example.chucknorris.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers

class CategoryViewModel(
    private val repository: CategoryRepository
): ViewModel() {

    lateinit var _categories: String

    fun getJoke(categoryName: String? = null) = liveData(Dispatchers.IO) {
        val response = repository.getJoke(categoryName)

        _categories = response.toString()
        emit(response)
    }

    fun getCategories() = liveData(Dispatchers.IO) {
        val response = repository.getCategories()

        _categories = response.toString()
        emit(response)
    }

    class CategoryViewModelFactory(
        private val repository: CategoryRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CategoryViewModel(repository) as T
        }
    }


}