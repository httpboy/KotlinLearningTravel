package com.lucky.kotlin.luckykotlinlearning


/**
 * 类型检测及自动类型转换
 */
fun main(args: Array<String>) {
    val length = getLength("12306")
    println("12306 length is $length")
}

fun getLength(obj: Any): Int? {
    if (obj is String) {
        return obj.length
    }

    return null
}

