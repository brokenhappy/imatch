package com.djinaandwout.imatch

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform