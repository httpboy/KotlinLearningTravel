package com.boy.learning.kotlinlearningtravel


/**
 *Kotlin返回与跳转
 * 1.return
 * 2.break
 * 3.continue
 * 4.标签处返回
 */
fun main(args: Array<String>) {
    //-----------------------return-------------------------------------
    //默认从最直接包围它的函数或者匿名函数返回
    val a = arrayOf(1, 2, 3, 0, 6)
    fun outer() {
        a.forEach {
            if (it == 0) {
                return
            }
            print("$it")
        }
    }
    outer()//输出结果-------------------------123-------------------------
    println()

    //从 lambda 表达式中返回，我们必须给它加标签并用以限制 return
    fun outer2() {
        a.forEach lit@{
            if (it == 0) {
                return@lit
            }
            print("$it")
        }
    }
    outer2()//输出结果-------------------------1236-------------------------
    println()

    //从 lambda 表达式中返回。通常情况下使用隐式标签更方便。 该标签与接受该 lambda 的函数同名
    fun outer3() {
        a.forEach {
            if (it == 0) {
                return@forEach
            }
            print("$it")
        }
    }
    outer3()//输出结果-------------------------1236-------------------------
    println()

    //-----------------------Break-------------------------------------
    loop@ for (i in 1..5) {
        for (j in 1..5) {
            if (j == 2) {
                print("$j,")
                break@loop
            }
        }
    }//输出结果-------------------------2,-------------------------
    println()


    //-----------------------Continue -------------------------------------
    loop@ for (i in 1..5) {
        for (j in 1..5) {
            if (j == 2) {
                print("$j,")
                continue@loop
            }
        }
    }//输出结果-------------------------2,2,2,2,2,-------------------------
    println()



    //-----------------------标签处返回 -------------------------------------
    fun foo() {
        arrayOf(1, 2, 3, 4, 6).forEach {
            if (it == 3) return // 非局部  直接返回到 foo() 的调用者
            print(it)
        }
        print(" done with foo function")
    }
    foo()//输出结果-------------------------12-------------------------
    println()

    //匿名函数替代 lambda 表达式
    fun foo4() {
        arrayOf(1, 2, 3, 4, 6).forEach(fun(value: Int) {
            if (value == 3) return // 局部 返回到匿名函数的调用者，即 forEach 循环
            print(value)
        })
        println()
        print("done with foo4 function")
    }
    foo4()
//    *********************************输出结果*********************************
//    1246
//    done with foo4 function
//    *********************************输出结果*********************************

    fun foo2() {
        arrayOf(1, 2, 3, 4, 6).forEach lit@{
            if (it == 3) return@lit // 局部 返回到该 lambda 表达式的调用者，即 forEach 循环
            print(it)
        }
    }
    foo2()//输出结果-------------------------12-------------------------
    println()

    fun foo3() {
        run loop@{
            listOf(1, 2, 3, 4, 5).forEach {
                if (it == 3) return@loop // 从传入 run 的 lambda 表达式非局部返回
                print(it)
            }
        }
        println()
        println("run 方法执行完毕")
    }
    foo3()
//    *********************************输出结果*********************************
//    12
//    run 方法执行完毕
//    *********************************输出结果*********************************


}
