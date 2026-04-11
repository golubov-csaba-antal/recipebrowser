package com.zappyware.recipebrowser.data

import kotlinx.serialization.Serializable

@Serializable
data class CategoryList(
    val categories: List<Category>,
)
