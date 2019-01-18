package com.lucky.kotlin.luckykotlinlearning


/**
 *Kotlin 循环控制
 * 1.For 循环
 * 2.while
 * 3.do...while
 */
fun main(args: Array<String>) {
    //-----------------------For 循环-------------------------------------
    var arrays = listOf("a", "b", "c", "d", "e")
    for (i in arrays) {//a,b,c,d,e,
        print("$i,")
    }
    println()


    for (i in arrays.indices) {//a,b,c,d,e,
        print(arrays[i] + ",")
    }
    println()


    for ((index, value) in arrays.withIndex()) {
        println("$index : $value")
    }


    //-----------------------while  循环-------------------------------------
    var x = 2
    while (x > 0) {//2,1,
        print("${x--},")
    }
    println()


    var y = 2
    do {//2,1,
        print("${y--},")
    } while (y > 0)
    println()


    //-----------------------标签处返回-------------------------------------
    val a = arrayOf(1, 2, 3, 0, 6)
    fun outer() {
        a.forEach {
            if (it == 0) {
                return
            }
            print("$it")
        }
    }
    outer()//123
    println()

    fun outer2() {
        a.forEach {
            if (it == 0) {
                return@forEach
            }
            print("$it")
        }
    }
    outer2()//1236
    println()

    fun outer3() {
        a.forEach(fun(it: Int) {
            if (it == 0) {
                return
            }
            print("$it")
        })
    }

    outer3()//1236
    println()

}
