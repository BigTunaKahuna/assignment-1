package com.interview.drugreport.exception

data class ProblemDetails(
    val type: String,
    val title: String,
    val status: Int,
    val detail: String?,
    val instance: String?
)