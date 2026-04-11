package com.zappyware.recipebrowser.network.themeal.data

import com.zappyware.recipebrowser.data.AreaList
import kotlinx.serialization.Serializable

@Serializable
data class TheMealAreaList(
    val meals: List<TheMealArea>,
)

fun TheMealAreaList.toAreaList(): AreaList {
    return AreaList(
        areas = meals.map { it.toArea() }
    )
}
