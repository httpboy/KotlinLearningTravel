package com.boy.learning.kotlinlearningtravel.basic

/**
 * 1.定义变量
 * 定义只读局部变量使用关键字 val 定义。只能为其赋值一次。
 *
 */
fun main(args: Array<String>) {
    //声明时初始化
    val a: Int = 1
    println(a)
    // 系统自动推断变量类型为Int
    val b = 2
    println(b)
    //不在声明时初始化
    val c: Int// 如果不在声明时初始化则必须提供变量类型
    c = 3// 明确赋值
    println(c)
    // 系统自动推断变量类型为Int
    var d = 4
    // 变量可修改
    d += 1
    println(d)
    //字符串模板
    var y = 1
    val yStr = "y is $y"
    println(yStr)
    //字符串模板-任意表达式：
    y = 2
    val s2 = "${yStr.replace("is", "was")}, but now is $y"
    println(s2)
}
