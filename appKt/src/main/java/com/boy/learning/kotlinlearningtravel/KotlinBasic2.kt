package com.lucky.kotlin.luckykotlinlearning

import android.os.Build.VERSION_CODES.P

fun main(args: Array<String>) {
    val sum = sum(5, 5)
    println(sum)
    val sum2 = sum2(6, 6)
    println(sum2)
    val sum3 = sum3(7, 7)
    println(sum3)
    printSum(8, 8)
    vars(1, 2, 3, 0, 6)
    //lambda表达式（匿名函数，即没有函数名的函数）使用
    val sumLambda: (Int, Int) -> Int = { x, y -> x + y }
    println(sumLambda(9, 9))
}

//函数定义使用关键字 fun，参数格式为：参数 : 类型
fun sum(a: Int, b: Int): Int {
    return a + b
}

//表达式作为函数体，返回类型自动推断：
fun sum2(a: Int, b: Int) = a + b

public fun sum3(a: Int, b: Int): Int = a + b   // public 方法则必须明确写出返回类型

//无返回值的函数(类似Java中的void)
public fun printSum(a: Int, b: Int): Unit {
    println(a + b)
}

//函数的可变参数可以用 vararg 关键字进行标识：
fun vars(vararg v: Int) {
    for (vt in v) {
        print(vt)
    }
    println()
}