package com.caioal.aula31.models

data class PageInfoModel (
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)
