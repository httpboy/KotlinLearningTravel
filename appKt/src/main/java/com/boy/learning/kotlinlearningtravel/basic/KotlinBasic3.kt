package com.boy.learning.kotlinlearningtravel.basic


/**
 * NULL检查机制
 */
fun main(args: Array<String>) {
    val str: String = "12306"
    println(str)//输出结果-------------------------12306-------------------------
    val name = null
    println(name)//输出结果-------------------------null-------------------------
    //var names = name.toInt()编译期提示错误,问题不大！Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type Nothing
    val names = name?.toInt()
    println(names)//输出结果-------------------------null-------------------------
    val names3 = name?.toInt() ?: "names3 is null"
    println(names3)//输出结果-------------------------names3 is null-------------------------
    val parseInt = parseInt("12306")
    println(parseInt)//输出结果-------------------------12306-------------------------
    val parseInt2 = parseInt(null)
    //如果parseInt2==null,直接打印null
    println(parseInt2?.length)//输出结果-------------------------null-------------------------
}

fun parseInt(str: String?): String? {
    if (str == null) {
        return null
    }
    return str.toString()
}
