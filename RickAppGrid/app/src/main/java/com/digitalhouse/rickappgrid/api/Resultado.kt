package com.digitalhouse.rickappgrid.api

import com.google.gson.annotations.SerializedName

data class Resultado(
    @SerializedName("results")
    val resultados: List<Personagem>
)