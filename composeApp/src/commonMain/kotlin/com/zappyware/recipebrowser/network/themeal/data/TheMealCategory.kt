package com.zappyware.recipebrowser.network.themeal.data

import com.zappyware.recipebrowser.data.Category
import kotlinx.serialization.Serializable

@Serializable
data class TheMealCategory(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String,
)

fun TheMealCategory.toCategory(): Category {
    return Category(
        id = idCategory,
        name = strCategory.trim(),
        image = strCategoryThumb.trim(),
        description = strCategoryDescription.trim(),
    )
}
