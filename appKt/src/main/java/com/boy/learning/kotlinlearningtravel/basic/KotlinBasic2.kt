package com.boy.learning.kotlinlearningtravel.basic

/**
 *定义函数
 */

//函数定义使用关键字 fun，参数格式为：参数 : 类型
fun sum(a: Int, b: Int): Int {
    return a + b
}

//表达式作为函数体，返回类型自动推断
fun sum2(a: Int, b: Int) = a + b

//函数无返回值(类似Java中的void),Unit可以省略
fun printSum(a: Int, b: Int): Unit {
    println(a + b)
}

//函数的可变参数可以用 vararg 关键字进行标识：
fun vars(vararg v: Int) {
    for (vt in v) {
        print(vt)
    }
    println()
}

fun main(args: Array<String>) {
    val sum = sum(5, 5)
    println(sum)
    val sum2 = sum2(6, 6)
    println(sum2)
    printSum(8, 8)
    vars(1, 2, 3, 0, 6)
    //lambda表达式（匿名函数，即没有函数名的函数）使用
    val sumLambda: (Int, Int) -> Int = { x, y -> x + y }
    println(sumLambda(9, 9))
}

