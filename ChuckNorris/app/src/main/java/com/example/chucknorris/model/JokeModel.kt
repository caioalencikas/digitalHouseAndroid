package com.example.chucknorris.model

import com.google.gson.annotations.SerializedName

data class JokeModel (
    @SerializedName("icon_url")
    val iconURL: String
    , val joke: String
)