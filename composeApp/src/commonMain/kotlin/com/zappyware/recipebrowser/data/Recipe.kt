package com.zappyware.recipebrowser.data

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Recipe(
    val id: String,
    val name: String,
    val category: String,
    val origin: String,
    val ingredients: List<Ingredient> = emptyList(),
    val instructions: String,
    val image: String? = null,
    val tags: List<String> = emptyList(),
    val video: String? = null,
    val source: String? = null,
    val imageSource: String? = null,
    val isCreativeCommonsConfirmed: String? = null,
    val modified: LocalDate? = null,
)
