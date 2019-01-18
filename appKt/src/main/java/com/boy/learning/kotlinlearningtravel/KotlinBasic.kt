package com.lucky.kotlin.luckykotlinlearning

/**
 * 定义常量与变量
 */
fun main(args: Array<String>) {
    //声明时初始化
    var a: Int = 1
    println(a)
    var b = 2// 系统自动推断变量类型为Int
    println(b)
    //不在声明时初始化
    var c: Int// 如果不在声明时初始化则必须提供变量类型
    c = 3// 明确赋值
    println(c)
    var x = 4// 系统自动推断变量类型为Int
    x += 1// 变量可修改
    println(x)
    //字符串模板
    var y = 1
    val yStr = "y is $y"
    println(yStr)
    //字符串模板-任意表达式：
    y = 2
    val s2 = "${yStr.replace("is", "was")}, but now is $y"
    println(s2)
}
