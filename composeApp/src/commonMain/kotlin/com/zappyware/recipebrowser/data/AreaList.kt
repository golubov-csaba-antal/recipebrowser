package com.zappyware.recipebrowser.data

import kotlinx.serialization.Serializable

@Serializable
data class AreaList(
    val areas: List<Area>,
)
