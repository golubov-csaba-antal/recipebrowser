package com.zappyware.recipebrowser

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform