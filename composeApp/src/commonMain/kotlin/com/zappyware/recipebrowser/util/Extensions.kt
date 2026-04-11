package com.zappyware.recipebrowser.util

fun String?.orDefaultError(): String =
    this ?: "Something went wrong"
