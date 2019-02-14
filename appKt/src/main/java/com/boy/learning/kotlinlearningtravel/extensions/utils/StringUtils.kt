package com.boy.learning.kotlinlearningtravel.extensions.utils

class StringUtils {
    var name: String = "StringUtils"
}

fun StringUtils.CustomGetLenth(): Int {
    return this.name.length
}