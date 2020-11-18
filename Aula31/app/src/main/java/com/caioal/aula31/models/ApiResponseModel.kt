package com.caioal.aula31.models

data class ApiResponseModel<T>(
    val info: PageInfoModel,
    val results: List<T>
)