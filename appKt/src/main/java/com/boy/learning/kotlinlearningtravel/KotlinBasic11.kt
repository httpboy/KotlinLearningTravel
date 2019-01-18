package com.lucky.kotlin.luckykotlinlearning


/**
 * Kotlin 接口
 * 1.实现接口
 * 2.接口中的属性
 * 3.函数重写
 */
fun main(args: Array<String>) {
    //-----------------------实现接口-------------------------------------
    ExtendsMyInterface().A()//ExtendsMyInterface.A
    ExtendsMyInterface().B()//MyInterface.B

    //-----------------------接口中的属性 -------------------------------------
    println(ExtendsMyInterface2().name)//boyi.chen

}
//-----------------------实现接口-------------------------------------
//一个类或者对象可以实现一个或多个接口。

interface MyInterface {
    fun A()
    fun B() {
        println("MyInterface.B")
    }
}

class ExtendsMyInterface : MyInterface {
    override fun A() {
        println("ExtendsMyInterface.A")
    }

}

//-----------------------接口中的属性 -------------------------------------
//接口中的属性只能是抽象的，不允许初始化值，接口不会保存属性值，实现接口时，必须重写属性
interface MyInterface2 {
    var name: String//抽象属性
}

class ExtendsMyInterface2 : MyInterface2 {
    override var name: String = "boyi.chen"
}