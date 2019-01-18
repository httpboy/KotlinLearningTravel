package com.lucky.kotlin.luckykotlinlearning


/**
 * Kotlin 条件控制
 * 1.IF 表达式
 * 2.When 表达式
 *
 */
fun main(args: Array<String>) {
    //普通使用
    var a: Int = 1
    var b: Int = 2
    var max: Int
    var min: Int
    if (a < b) {
        max = b
    } else {
        max = a
    }
    println(max)//2

    // 作为表达式
    min = if (a < b) a else b
    println(min)//1

    //IF 表达式的结果赋值给一个变量,这里不需要三元操作符也可以
    val max2 = if (a > b) {
        print("Choose a:")
        a
    } else {
        print("Choose b:")
        b
    }
    println(max2)//1

    //使用 in 运算符来检测某个数字是否在指定区间内
    val x = 5
    if (x in 1..8) {
        println("x 在区间内")//x 在区间内
    }
    //----------------------- When 表达式-------------------------------------
    //else 同 switch 的 default。如果其他分支都不满足条件将会求值 else 分支
    val y = 5

    when (y) {//输出 x 不是1 也不是5
        1 -> println("x==1")
        2 -> println("x==2")
        else -> {
            println("x 不是1 也不是5")
        }
    }

    val z = 5
    when (z) {  //输出 x==1 or x==5
        1, 5 -> println("x==1 or x==5")
        else -> println("x 不是1 也不是5")
    }

    val h = 0
    var validArrays = arrayOf(1, 2, 3, 0, 6)
    when (h) {  //输出 x是合法数字
        in 1..5 -> println("x在1-5之间")
        in validArrays -> println("x是合法数字")
        !in 10..20 -> println("x不在10-20之间")
        else -> println("x到底属于什么范围")
    }

    //is检测特定类型
    fun hasString(x: Any) = when (x) {
        is String -> true
        else -> false
    }
    println(hasString("boyi.chen"))//true
    println(hasString(12306))//false

    //when 也可以用来取代 if-else if链
    val d = 10
    when {//d在区间1-10之间
        d in 1..10 -> println("d在区间1-10之间")
        else -> println("else")
    }

}
