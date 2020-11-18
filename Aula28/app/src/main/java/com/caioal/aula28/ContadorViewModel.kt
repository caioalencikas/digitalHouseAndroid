package com.caioal.aula28

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContadorViewModel: ViewModel() {

    var contador = MutableLiveData<Int>().apply{ value = 0 }

    fun incrementar() {
        contador.value = contador.value!! + 1
    }
}