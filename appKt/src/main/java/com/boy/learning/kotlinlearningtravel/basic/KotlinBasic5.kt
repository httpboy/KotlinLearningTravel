package com.boy.learning.kotlinlearningtravel.basic


/**
 * 使用区间（range）
 * 1.in 正序区间
 * 2.downTo  逆序区间
 * 3.until 直到..结束
 * 4.step 步长
 */
//打印出1-10之间的数
fun print1(): Unit {
    for (i in 1..10) {
        print("$i,")
    }
    println()
}

// 什么都不输出
fun print2(): Unit {
    for (i in 10..1) {
        print("$i,")
    }
    println()
}

// 使用step指定步长，每次遍历下标索引加3
//输出结果 1,4,7,10,
fun print3(): Unit {
    for (i in 1..10 step 3) {
        print("$i,")
    }
    println()
}

//输出结果 1,2,3,4,5,6,7,8,9,
fun print4(): Unit {
    for (i in 1 until 10) {
        print("$i,")
    }
    println()
}

//输出结果 10,9,8,7,6,5,4,3,2,1,
fun print5(): Unit {
    for (i in 10 downTo 1) {
        print("$i,")
    }
    println()
}

fun main(args: Array<String>) {
    print1()//输出结果-------------------------1,2,3,4,5,6,7,8,9,10,-------------------------
    print2()//输出结果------------------------- -------------------------
    print3()//输出结果-------------------------1,4,7,10,-------------------------
    print4()//输出结果-------------------------1,2,3,4,5,6,7,8,9,-------------------------
    print5()//输出结果-------------------------10,9,8,7,6,5,4,3,2,1,-------------------------
}

