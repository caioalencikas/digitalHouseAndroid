package com.digitalhouse.rickappgrid.api

import com.google.gson.annotations.SerializedName

data class Localizacao(
    @SerializedName("name")
    var nome : String
)