package com.lucky.kotlin.luckykotlinlearning


/**
 * Kotlin 条件控制
 * 1.if 表达式
 * 2.When 表达式
 * 3.for
 * 4.while
 *
 */
fun main(args: Array<String>) {
    //----------------------- if 表达式-------------------------------------
    //传统用法
    val a: Int = 1
    val b: Int = 2
    val max: Int
    val min: Int
    if (a < b) {
        max = b
    } else {
        max = a
    }
    println(max)//输出结果-------------------------2-------------------------

    // 作为表达式
    min = if (a < b) a else b
    println(min)//输出结果-------------------------1-------------------------

    //IF 表达式的结果赋值给一个变量,这里不需要三元操作符也可以
    val max2 = if (a > b) {
        println("Choose a:")
        a
    } else {
        println("Choose b:")
        b
    }
    println(max2)

//    *********************************输出结果*********************************
//    Choose b:
//    2
//    *********************************输出结果*********************************

    //使用 in 运算符来检测某个数字是否在指定区间内
    val x = 5
    if (x in 1..8) {
        println("x 在区间内")//输出结果-------------------------x 在区间内-------------------------
    }


    //----------------------- When 表达式-------------------------------------
    //when 取代了类 C 语言的 switch 操作符
    //else 类似 switch 的 default。如果其他分支都不满足条件将会求值 else 分支
    val y = 5

    when (y) {
        1 -> println("x==1")
        2 -> println("x==2")
        else -> {
            println("x 不是1 也不是5")
        }
    }
//    *********************************输出结果*********************************
//    x 不是1 也不是5
//    *********************************输出结果*********************************

    //如果很多分支需要用相同的方式处理，则可以把多个分支条件放在一起，用逗号分隔
    val z = 5
    when (z) {
        1, 5 -> println("x==1 or x==5")
        else -> println("x 不是1 也不是5")
    }

//    *********************************输出结果*********************************
//    x==1 or x==5
//    *********************************输出结果*********************************

    //我们也可以检测一个值在（in）或者不在（!in）一个区间或者集合中：
    val h = 0
    var validArrays = arrayOf(1, 2, 3, 0, 6)
    when (h) {
        in 1..5 -> println("x在1-5之间")
        in validArrays -> println("x是合法数字")
        !in 10..20 -> println("x不在10-20之间")
        else -> println("x到底属于什么范围")
    }//输出 x是合法数字

    //is检测特定类型
    fun hasString(x: Any) = when (x) {
        is String -> true
        else -> false
    }
    println(hasString("boyi.chen"))//true
    println(hasString(12306))//false

    //when 也可以用来取代 if-else if链
    val d = 10
    when {
        d in 1..10 -> println("d在区间1-10之间")
        else -> println("else")
    }//d在区间1-10之间


    //-----------------------For 循环-------------------------------------
    val arrays = listOf("a", "b", "c", "d", "e")
    //对任何提供迭代器（iterator）的对象进行遍历
    for (i in arrays) {
        print("$i,")
    }//a,b,c,d,e,
    println()


    //通过索引遍历一个数组或者一个 list
    for (i in arrays.indices) {
        print(arrays[i] + ",")
    }//a,b,c,d,e,
    println()


    //可以用库函数 withIndex
    for ((index, value) in arrays.withIndex()) {
        println("$index : $value")
    }
//    *********************************输出结果*********************************
//    0 : a
//    1 : b
//    2 : c
//    3 : d
//    4 : e
//    *********************************输出结果*********************************

    //-----------------------while循环-------------------------------------
    var xx = 2
    while (xx > 0) {
        print("${xx--},")
    }//2,1,
    println()


    var yy = 2
    do {
        print("${yy--},")
    } while (yy > 0)//2,1,
    println()
}
