package com.boy.learning.kotlinlearningtravel.basic


/**
 * 类型检测及自动类型转换
 */
fun main(args: Array<String>) {
    val length = getLength("12306")
    println("12306 length is $length")//输出结果-------------------------12306 length is 5-------------------------
}

fun getLength(obj: Any): Int? {
    if (obj is String) {
        //obj在该条件分支内自动转换成 `String`
        return obj.length
    }

    return null
}

