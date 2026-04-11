package com.zappyware.recipebrowser.network.themeal.data

import com.zappyware.recipebrowser.data.CategoryList
import kotlinx.serialization.Serializable

@Serializable
data class TheMealCategoryList(
    val categories: List<TheMealCategory>,
)

fun TheMealCategoryList.toCategoryList(): CategoryList {
    return CategoryList(
        categories = categories.map { it.toCategory() }
    )
}
