package com.zappyware.recipebrowser.network.themeal.data

import com.zappyware.recipebrowser.data.Area
import kotlinx.serialization.Serializable

@Serializable
data class TheMealArea(
    val strArea: String,
)

fun TheMealArea.toArea(): Area {
    return Area(
        name = strArea,
    )
}
