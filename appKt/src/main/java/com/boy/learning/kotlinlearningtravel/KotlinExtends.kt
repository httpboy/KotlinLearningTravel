package com.boy.learning.kotlinlearningtravel


/**
 * Kotlin 继承
 */
fun main(args: Array<String>) {
    //---------------------------继承-------------------------------------
    //Kotlin 中所有类都继承该 Any 类，它是所有类的超类，对于没有超类型声明的类是默认超类
    val extends = ExtendsExample("boyi.chen")
    println(extends.name)//输出结果-------------------------boyi.chen-------------------------


    //-----------------------基类初始化-------------------------------------
    val example2 = ExtendsExample2("boy", 100)

//    *********************************输出结果*********************************
//    -------基类次级构造函数---------
//    基类----name:boy,age:100,sex:男
//    -------继承类，次级构造函数---------
//    继承类----name:boy,age:100
//    *********************************输出结果*********************************


    //-----------------------重写方法-------------------------------------
    val itWorker = ItWorker()
    itWorker.doWork()//输出结果-------------------------我是Android开发者-------------------------


    //-----------------------重写属性 var覆盖val-------------------------------------
    //属性覆盖与方法覆盖类似；
    //在超类中声明然后在派生类中重新声明的属性必须以 override 开头，并且它们必须具有兼容的类型
    println(TestDemo1(666).count)//输出结果-------------------------666-------------------------
    TestDemo1(666).count = 6666


    //-----------------------重写属性 val覆盖val-------------------------------------
    //你也可以用一个 var 属性覆盖一个 val 属性，但反之则不行。这是允许的，
    //因为一个 val 属性本质上声明了一个 getter 方法，而将其覆盖为 var
    //只是在子类中额外声明一个 setter 方法。
    println(TestDemo2().name)//输出结果-------------------------boyi.chen-------------------------
//    TestDemo2().name = "陈博易"//编译出错 Val cannot be reassigned


    //-----------------------覆盖规则-------------------------------------
    val c = C()
    c.f()
//    *********************************输出结果*********************************
//    A.f
//    B.f
//    *********************************输出结果*********************************


    //-----------------------派生类初始化顺序-------------------------------------
    Derived("boy", "chen")
//    *********************************输出结果*********************************
//    【基类】参数name转化为大小: Boy
//    初始化 【基类】init代码块
//    初始化【基类】name长度: 3
//    初始化 【派生类】 init代码块
//    初始化【派生类】name长度: 7
//    *********************************输出结果*********************************


    //-----------------------调用超类实现-------------------------------------
    //派生类中的代码可以使用 super 关键字调用其超类的函数与属性访问器的实现
    Bar().f()
    println(Bar().x)
//    *********************************输出结果*********************************
//    Foo.f()
//    Bar.f()
//    2
//    *********************************输出结果*********************************

    //内部类中访问外部类的超类
    Bar().InnerBar().g()
//    *********************************输出结果*********************************
//    Foo.f()
//    1
//    *********************************输出结果*********************************

}

//基类
open class Example(name: String) {
    public var name = name

    //次级构造函数
    constructor(name: String, age: Int) : this(name) {
        println("-------基类次级构造函数---------")
        println("基类----name:$name,age:$age")
    }

    //次级构造函数
    constructor(name: String, age: Int, sex: String) : this(name) {
        println("-------基类次级构造函数---------")
        println("基类----name:$name,age:$age,sex:$sex")
    }
}

//如果派生类有一个主构造函数，其基类型可以（并且必须） 用基类的主构造函数参数就地初始化。
class ExtendsExample(name: String) : Example(name) {}

//如果派生类没有主构造函数，则必须在每一个二级构造函数中用
// super 关键字初始化基类， 或者在代理另一个构造函数。
// 初始化基类时，可以调用基类的不同构造方法。
class ExtendsExample2 : Example {
    //子类次级构造函数
    constructor(name: String, age: Int) : super(name, age, "男") {
        println("-------继承类，次级构造函数---------")
        println("继承类----name:$name,age:$age")
    }
}

//-----------------------重写方法-------------------------------------
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


//-----------------------覆盖规则-------------------------------------
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
    // 编译器要求覆盖 f()：
    override fun f() {
        super<A>.f()
        super<B>.f()
    }
}

//-----------------------属性重写-------------------------------------
interface TestDemo {
    val count: Int
    val name: String
}

class TestDemo1(override var count: Int) : TestDemo {
    override val name: String
        get() = "boyi.chen"
}

class TestDemo2 : TestDemo {
    override val name: String
        get() = "boyi.chen"
    override var count: Int = 0
}

//-----------------------派生类初始化顺序-------------------------------------
open class Base2(val name: String) {

    init {
        println("初始化 【基类】init代码块")
    }

    open val size: Int =
            name.length.also { println("初始化【基类】name长度: $it") }
}

class Derived(
        name: String,
        val lastName: String
) : Base2(name.capitalize().also { println("【基类】参数name转化为大小: $it") }) {

    init {
        println("初始化 【派生类】 init代码块")
    }

    override val size: Int =
            (super.size + lastName.length).also { println("初始化【派生类】name长度: $it") }
}


//-----------------------调用超类实现-------------------------------------
open class Foo {
    open fun f() {
        println("Foo.f()")
    }

    open val x: Int get() = 1
}

class Bar : Foo() {
    override fun f() {
        super.f()
        println("Bar.f()")
    }

    override val x: Int get() = super.x + 1

    inner class InnerBar {
        fun g() {
            super@Bar.f() // 调用 Foo 实现的 f()
            println(super@Bar.x) // 使用 Foo 实现的 x 的 getter
        }
    }
}


