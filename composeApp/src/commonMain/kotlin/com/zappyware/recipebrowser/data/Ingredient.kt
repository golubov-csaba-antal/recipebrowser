package com.zappyware.recipebrowser.data

import kotlinx.serialization.Serializable

@Serializable
data class Ingredient(
    val name: String,
    val id: String? = null,
    val measure: String? = null,
    val image: String? = null,
    val description: String? = null,
)
