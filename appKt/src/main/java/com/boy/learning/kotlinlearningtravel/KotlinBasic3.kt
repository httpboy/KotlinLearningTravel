package com.lucky.kotlin.luckykotlinlearning


/**
 * NULL检查机制
 */
fun main(args: Array<String>) {
    var str: String = "12306"
    println(str)

    var name = null
    println(name)
    //var names = name.toInt()编译期提示错误,问题不大！Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type Nothing
    var names = name?.toInt()
    println(names)
//    val names2 = name!!.toInt()//抛出空指针异常
//    println(names2)
    var names3 = name?.toInt() ?: "names3 is null"
    println(names3)

    val parseInt = parseInt("12306")
    println(parseInt)
    val parseInt2 = parseInt(null)
    println(parseInt2?.length)//如果parseInt2==null,直接打印null
}

fun parseInt(str: String?): String? {
    if (str == null) {
        return null
    }
    return str.toString()
}
