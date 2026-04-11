package com.zappyware.recipebrowser.network

data class ApiResponse<T>(
    val data: T? = null,
    val error: String? = null,
)
