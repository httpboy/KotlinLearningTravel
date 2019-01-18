package com.lucky.kotlin.luckykotlinlearning


/**
 * Kotlin 继承
 * 1.构造函数
 * 2.重写
 * 3.属性重写
 */
fun main(args: Array<String>) {
    //-----------------------Kotlin 继承 -------------------------------------
    //Kotlin 中所有类都继承该 Any 类，它是所有类的超类，对于没有超类型声明的类是默认超类
    val extends = ExtendsExample("boyi.chen")
    println(extends.name)//boyi.chen

    //-----------------------构造函数-------------------------------------

    /* 输出 -------基类次级构造函数---------
            基类----name:boy,age:100
    -------继承类，次级构造函数---------
    继承类----name:boy,age:100*/
    val example2 = ExtendsExample2("boy", 100)

    //-----------------------重写-------------------------------------
    val itWorker = ItWorker()
    itWorker.doWork()//输出 我是Android开发者

    val c = C()
    c.f()//输出 A.f /n B.f


}

//基类
open class Example(name: String) {
    public var name = name

    //次级构造函数
    constructor(name: String, age: Int) : this(name) {
        println("-------基类次级构造函数---------")
        println("基类----name:$name,age:$age")
    }
}

class ExtendsExample(name: String) : Example(name) {}

//如果子类没有主构造函数，则必须在每一个二级构造函数中用
// super 关键字初始化基类， 或者在代理另一个构造函数。
// 初始化基类时，可以调用基类的不同构造方法。
class ExtendsExample2 : Example {
    //子类次级构造函数
    constructor(name: String, age: Int) : super(name, age) {
        println("-------继承类，次级构造函数---------")
        println("继承类----name:$name,age:$age")
    }
}

//-----------------------重写-------------------------------------
//在基类中，使用fun声明函数时，此函数默认为final修饰，不能被子类重写。
// 如果允许子类重写该函数，那么就要手动添加 open 修饰它,
// 子类重写方法使用 override 关键词：
open class People {
    open fun doWork() {
        println("做工作")
    }
}

class ItWorker : People() {
    override fun doWork() {
        println("我是Android开发者")
    }
}

//如果有多个相同的方法（继承或者实现自其他类，如A、B类），
// 则必须要重写该方法，使用super范型去选择性地调用父类的实现。
open class A {
    open fun f() {
        println("A.f")
    }
}

interface B {
    fun f() {
        println("B.f")
    }
}

class C : A(), B {
    override fun f() {
        super<A>.f()
        super<B>.f()
    }
}

//-----------------------属性重写-------------------------------------
interface TestDemo {
    val count: Int
}

class TestDemo1(override var count: Int) : TestDemo

class TestDemo2 : TestDemo {
    override var count: Int = 0
}



