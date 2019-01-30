package com.boy.learning.kotlinlearningtravel


/**
 * Kotlin 接口
 * 1.实现接口
 * 2.接口中的属性
 */
fun main(args: Array<String>) {
    //-----------------------实现接口-------------------------------------
    ExtendsMyInterface().A()//输出结果-------------------------ExtendsMyInterface.A-------------------------
    ExtendsMyInterface().B()//输出结果-------------------------MyInterface.B-------------------------

    //-----------------------接口中的属性 -------------------------------------
    println(ExtendsMyInterface2().name)//输出结果-------------------------boyi.chen-------------------------

}

//-----------------------接口-------------------------------------
//一个类或者对象可以实现一个或多个接口。
interface MyInterface {
    fun A()
    fun B() {
        println("MyInterface.B")
    }
}

//-----------------------实现接口-------------------------------------
//一个类或者对象可以实现一个或多个接口。
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